package at.lolf.plugins.basic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlotTP implements CommandExecutor {

	public PlotTP(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = ((Player) sender);
			p.teleport(new Location(Bukkit.getWorld("plot"), 
					Bukkit.getWorld("plot").getSpawnLocation().getX(), 
					Bukkit.getWorld("plot").getSpawnLocation().getY(), 
					Bukkit.getWorld("plot").getSpawnLocation().getZ()));
			return true;
		}
		return false;
	}

}
