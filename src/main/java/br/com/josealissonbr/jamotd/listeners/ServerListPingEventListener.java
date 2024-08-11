package br.com.josealissonbr.jamotd.listeners;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.List;

import static br.com.josealissonbr.jamotd.Main.*;

public class ServerListPingEventListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        ConfigurationSection cfg = getInstance().getConfig().getConfigurationSection("Config");

        List<String> motds = cfg.getStringList("motds");

        // Randomiza a mensagem de motd
        String motd = motds.get((int) (Math.random() * motds.size()));

        motd = motd.replace("&", "§");

        event.setMotd(motd);
    }

}
