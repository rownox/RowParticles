package net.rowparticles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static net.rowparticles.ParticleAnim.drawParticle;

public final class RowParticles extends JavaPlugin implements Listener {

    Plugin plugin = this;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        new BukkitRunnable() {
            public void run() {
                drawParticle(p, plugin, 255, 255, 255);
            }
        }.runTaskTimer(plugin, 0, 100);
    }
}
