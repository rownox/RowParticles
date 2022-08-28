package net.rowparticles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleAnim {
    public static void drawParticle(Player p, Plugin plugin, int R, int G, int B) {
        new BukkitRunnable() {
            double t = 0;
            Location loc = p.getLocation();
            public void run() {
                t = t + 0.1 * Math.PI;

                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI/35) {
                    double x = t * Math.cos(theta);
                    double y = Math.exp(0.1 * t) * Math.sin(t) * 1.5;
                    double z = t * Math.sin(theta);

                    loc.add(x, y, z);
                    loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(org.bukkit.Color.fromRGB(R, G, B), 2));
                    loc.subtract(x, y, z);
                }
                if (t > 3) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }
}
