package at.lolf.plugins.pvp;

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
					
						Location loc = new Location(Bukkit.getWorld("pvp"), x, y, z, yaw, pitch);
					
						player.teleport(loc);
						player.playSound(player.getLocation(), Sound.CLICK, 1, 5);
					}else{
						player.sendMessage("§2[§aPvP§2] §7Diese Map gibt es nicht!");
					}
					
					return true;
					
				}else if(!arg[1].equalsIgnoreCase("") && player.hasPermission("pvp.admin") && arg[0].equalsIgnoreCase("set")){
					main.cfg.set("Maps." + arg[1] + ".x", player.getLocation().getBlockX());
					main.cfg.set("Maps." + arg[1] + ".y", player.getLocation().getBlockY());
					main.cfg.set("Maps." + arg[1] + ".z", player.getLocation().getBlockZ());
					main.cfg.set("Maps." + arg[1] + ".yaw", player.getLocation().getYaw());
					main.cfg.set("Maps." + arg[1] + ".pitch", player.getLocation().getPitch());
					
					player.sendMessage("§2[§aPvP§2] §7Du hast den Spawn für die Map §6" + arg[1] + " §2gesetzt");
					return true;
				}else if(!arg[1].equalsIgnoreCase("") && player.hasPermission("pvp.admin") && arg[0].equalsIgnoreCase("del")){
					main.cfg.set("Maps." + arg[1], "");
					
					
					player.sendMessage("§2[§aPvP§2] §7Der Spawn für die Map §6" + arg[1] + " §2 wurde gelöscht");
					
					return true;
				}
			
		}
		return false;
	}

}
