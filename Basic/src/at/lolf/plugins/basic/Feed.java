package at.lolf.plugins.basic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;

	public Feed(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		if(sender instanceof Player){
			if(((Player) sender).getPlayer().hasPermission(Permlist.FEED)){
				((Player) sender).getPlayer().setFoodLevel(20);
				((Player) sender).getPlayer().sendMessage("§2[§aBasic§2] §7Du bist jetzt satt!");
			}else{
				((Player) sender).getPlayer().sendMessage("§2[§aBasic§2] §cDu darfst das nicht machen!");
			}
			return true;
		}
		return false;
	}

}
