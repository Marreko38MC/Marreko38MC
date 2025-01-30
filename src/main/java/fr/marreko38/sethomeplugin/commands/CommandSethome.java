package fr.marreko38.sethomeplugin.commands;

import fr.marreko38.sethomeplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class CommandSethome implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (s.equalsIgnoreCase("sethome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (args.length == 0) {
                    p.sendMessage("&4Erreur : /sethome <nom>");
                    return false;
                }
                if (args.length == 1) {
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".world", p.getLocation().getWorld().getName());
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".x", p.getLocation().getX());
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".y", p.getLocation().getY());
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".z", p.getLocation().getZ());
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".pitch", p.getEyeLocation().getPitch());
                    Main.getInstance().getConfig().set("home."+ p.getName().toString() + "." + args[0] + ".yaw", p.getEyeLocation().getYaw());
                    Main.getInstance().saveConfig();
                    p.sendMessage("Le home" + args[0] + "a bien été sauvegarder !");
                    return false;
                }
                if (args.length >= 2) {
                    p.sendMessage("&4Erreur : /sethome <nom>");
                    return false;
                }
            }

        }

        if (s.equalsIgnoreCase("home")) {
            if (sender instanceof Player){

                Player p = (Player) sender;
                if (args.length >= 2) {
                    p.sendMessage("&4Erreur : /home <nom>");
                    return false;
                }
                if (args.length == 1) {
                    if (Main.getInstance().getConfig().contains("home." + p.getName().toString() + "."+ args[0])){
                        World w = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("home." + p.getName().toString() + "."+ args[0] +".world"));
                        double x = Main.getInstance().getConfig().getDouble("home." + p.getName().toString() + "."+ args[0] +".x");
                        double y = Main.getInstance().getConfig().getDouble("home." + p.getName().toString() + "."+ args[0] +".y");
                        double z = Main.getInstance().getConfig().getDouble("home." + p.getName().toString() + "."+ args[0] +".z");
                        double pitch = Main.getInstance().getConfig().getDouble("home." + p.getName().toString() + "."+ args[0] +".pitch");
                        double yaw = Main.getInstance().getConfig().getDouble("home." + p.getName().toString() + "."+ args[0] +".yaw");
                        p.teleport(new Location(w, x, y, z, (float) yaw, (float) pitch));
                        p.sendMessage("&cVous avez bien été téléporté a votre home"+ args);
                    } else{
                        p.sendMessage("&4Erreur le home"+ args[0] +"n'existe pas !");
                        return false;
                    }
                    if (args.length >= 2) {
                        p.sendMessage("&4Erreur : /home <nom>");
                        return false;
                      } else {
                        sender.sendMessage("&4Seul un joueur peut executer cette command!");
                    }
                }
                if(s.equalsIgnoreCase("delhome")){
                    if(sender instanceof Player){

                        if (args.length >= 2) {
                            p.sendMessage("&4Erreur : /delhome <nom>");
                            return false;
                        }
                    }

                    if (args.length >= 0) {
                        p.sendMessage("&4Erreur : /delhome <nom>");
                        return false;

                }

                    if(args.length == 1){
                        if (Main.getInstance().getConfig().contains("home." + p.getName().toString() + "."+ args[0])) {
                            Main.getInstance().getConfig().set("home." + p.getName().toString() + "."+ args[0], null);
                            Main.getInstance().saveConfig();
                            p.sendMessage("&a&lvotre home"+ args[0] +"a bien été supprimer");
                            return false;
                        } else{
                                p.sendMessage("&4Erreur le home"+ args[0] +"n'existe pas !");
                                return false;
                        }
                    }

                return false;
            }

        }

        return false;
    }
        return false;
    }

    {

    }
}
