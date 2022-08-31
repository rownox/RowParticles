package me.rownox.rowparticles;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class RowParticles extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RowParticles Enabled");
    }
    @Override
    public void onDisable() {
        getLogger().info("RowParticles Disabled");
    }

    /**
     * Draw particle based off of presets.
     * @param plugin your plugin
     * @param p the player you want to spawn the particle for
     * @param preset the preset you want to use e.g. {@code Presets.WAVE}
     * @param color color of the particles
     */
    public static void drawParticle(final Plugin plugin, final Player p, final Presets preset, final Color color) {
        new BukkitRunnable() {
            final double time = 0.15 * Math.PI;
            final Location loc = p.getLocation();
            public void run() {
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / preset.getSaturation()) {

                    double x = time * Math.cos(theta) * preset.getRadius();
                    double y = Math.exp(0.1 * time) * Math.sin(time) * preset.getAmplitude();
                    double z = time * Math.sin(theta) * preset.getRadius();

                    loc.add(x, y, z);
                    final World world = loc.getWorld();
                    if (world != null) world.spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(color, 2));
                    else Bukkit.getLogger().severe("World Not Found!");
                    loc.subtract(x, y, z);
                }

                if (time > preset.getDuration()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }
}
