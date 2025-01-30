package fr.marreko38.sethomeplugin;

import fr.marreko38.sethomeplugin.commands.CommandSethome;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instance;

    public static Main getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        System.out.println("Lancelent du Plugin Sethome");
        // Lancement du Plugin
        instance = this;
        getCommand("sethome").setExecutor(new CommandSethome());
        getCommand("home").setExecutor(new CommandSethome());
        getCommand("delhome").setExecutor(new CommandSethome());
    }

    @Override
    public void onDisable() {
        System.out.println("Arret du Plugin Sethome");
        // Arret du Plugin
    }
}
