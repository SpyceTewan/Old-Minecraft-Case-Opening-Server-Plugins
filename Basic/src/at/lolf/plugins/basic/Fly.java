package at.lolf.plugins.basic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main main;

	public Fly(Main main){
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			if(player.hasPermission(Permlist.FLY)){
				
				if(!player.getAllowFlight()){
					player.setAllowFlight(true);
					player.sendMessage("§2[§aBasic§2] §7Du fliegst jetzt!");
				}else{
					player.setAllowFlight(false);
					player.sendMessage("§2[§aBasic§2] §7Du fliegst jetzt nicht mehr!");
				}
			}else{
				player.sendMessage("§2[§aBasic§2] §cDu darfst das nicht machen!");
			}
			
		}
		
		return true;
	}
	
	
	
}
