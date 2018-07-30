package at.lolf.plugins.caseopener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;

public class Economy implements CommandExecutor {



	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		
		
		if(arg[1].equalsIgnoreCase("give") && sender.hasPermission(Permlist.ECO_CHANGE)){
			Points.addPoints(arg[0], Integer.parseInt(arg[2]));
			sender.sendMessage("§6" + arg[0] + " §2hat jetzt §6" + arg[2]);
			return true;
		}
		if(sender.hasPermission(Permlist.ECO_CHANGE)){
			if(arg[1].equalsIgnoreCase("set")){
			
				Points.setPoints(arg[0], Integer.parseInt(arg[2]));
				sender.sendMessage("§6" + arg[0] + " §2hat jetzt §6" + arg[2]);
				SidebarList.updateSidebar(Bukkit.getPlayer(arg[0]));
				
				return true;
			}
		
			if(arg[1].equalsIgnoreCase("take")){
				Points.removePoints(arg[0], Integer.parseInt(arg[2]));
				sender.sendMessage("§6" + arg[0] + " §2hat jetzt §6" + arg[2]);
				
				SidebarList.updateSidebar(Bukkit.getPlayer(arg[0]));
				
				return true;
			}
		}else{
			sender.sendMessage("§2Das darfst du nicht machen!");
		}
		
		if(sender.hasPermission(Permlist.ECO_SEE)){
			if(arg[1].equalsIgnoreCase("see") && sender.hasPermission(Permlist.ECO_SEE)){
				sender.sendMessage("§6" + arg[0] + " §2hat §6" + Points.getPoints(arg[0]) + " §2$");
				return true;
			}
		}else{
			sender.sendMessage("§2Das darfst du nicht machen!");
		}
		
		return false;
	}

}
