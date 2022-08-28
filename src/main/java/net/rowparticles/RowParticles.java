package net.rowparticles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RowParticles extends JavaPlugin{

    public static final List<Presets> presets = new ArrayList<>(Arrays.asList(
            new Presets("Wave", 2, 0.5, 20, 2)
    ));

    @Override
    public void onEnable() {}
    @Override
    public void onDisable() {}

    public void drawParticle(Plugin plugin, Player p, String name, int R, int G, int B) {
        new BukkitRunnable() {
            double time = 0;
            final Location loc = p.getLocation();
            public void run() {
                time = time + 0.15 * Math.PI;

                for (Presets preset : presets) {
                    if (preset.getName().equalsIgnoreCase(name)) {
                        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / preset.getSat()) {

                            double x = time * Math.cos(theta) * preset.getRad();
                            double y = Math.exp(0.1 * time) * Math.sin(time) * preset.getAmp();
                            double z = time * Math.sin(theta) * preset.getRad();

                            loc.add(x, y, z);
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(org.bukkit.Color.fromRGB(R, G, B), 2));
                            loc.subtract(x, y, z);
                        }

                        if (time > preset.getDur()) {
                            this.cancel();
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }
}
