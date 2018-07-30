package at.lolf.plugins.jumpandrun;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warps implements CommandExecutor {

	private Main main;

	public Warps(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
			
				if(!arg[0].equalsIgnoreCase("set") && !arg[0].equalsIgnoreCase("del")){
					
					double x = main.cfg.getDouble("Maps." + arg[0] + ".x");
					double y = main.cfg.getDouble("Maps." + arg[0] + ".y");
					double z = main.cfg.getDouble("Maps." + arg[0] + ".z");
					float yaw = (float )main.cfg.getDouble("Maps." + arg[0] + ".yaw");
					float pitch = (float) main.cfg.getDouble("Maps." + arg[0] + ".pitch");
					
					if(x != 0 && y != 0 && z != 0 && yaw != 0 && pitch != 0){
					
						Location loc = new Location(Bukkit.getWorld("Jar"), x, y, z, yaw, pitch);
					
						player.teleport(loc);
						player.playSound(player.getLocation(), Sound.CLICK, 1, 10);
					}else{
						player.sendMessage("§2[§aJump and Run§2] §7Dieses Jump And Run gibt es nicht!");
					}
					
					return true;
					
				}else if(!arg[1].equalsIgnoreCase("") && player.hasPermission("jar.admin") && arg[0].equalsIgnoreCase("set")){
					main.cfg.set("Maps." + arg[1] + ".x", player.getLocation().getBlockX());
					main.cfg.set("Maps." + arg[1] + ".y", player.getLocation().getBlockY());
					main.cfg.set("Maps." + arg[1] + ".z", player.getLocation().getBlockZ());
					main.cfg.set("Maps." + arg[1] + ".yaw", player.getLocation().getYaw());
					main.cfg.set("Maps." + arg[1] + ".pitch", player.getLocation().getPitch());
					
					player.sendMessage("§2[§aJump and Run§2] §7Der Spawn für das Jump And Run §6" + arg[1] + " §2wurde gesetzt");
					return true;
				}else if(!arg[1].equalsIgnoreCase("") && player.hasPermission("jar.admin") && arg[0].equalsIgnoreCase("del")){
					main.cfg.set("Maps." + arg[1], null);
					
					
					player.sendMessage("§2[§aJump and Run§2] §7Das Jump and Run §6" + arg[1] + " §2 wurde gelöscht");
					
					return true;
				}
			
		}
		return false;
	}

}
