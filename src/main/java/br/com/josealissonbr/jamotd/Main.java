package br.com.josealissonbr.jamotd;

import br.com.josealissonbr.jamotd.listeners.ServerListPingEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfiguration();

        attachEventListeners();

        Bukkit.getConsoleSender().sendMessage("§a[JAMotd] successfully initialized!");
    }

    private void loadConfiguration(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    private void attachEventListeners(){
        getServer().getPluginManager().registerEvents(new ServerListPingEventListener(), this);
    }

    public static Main getInstance(){
        return instance;
    }
}
