package at.lolf.plugins.basic;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;

	public Heal(Main main) {
		this.main = main;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
			if(player.hasPermission(Permlist.HEAL)){
			
				player.setHealth(20);
				player.sendMessage("§2[§aBasic§2] §7Du bist geheilt!");
			}else{
				player.sendMessage("§2[§aBasic§2] §cDu darfst das nicht machen!");
			}
		}
		
		return true;
	}

}
