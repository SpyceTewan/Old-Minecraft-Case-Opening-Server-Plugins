package at.lolf.plugins.basic;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trash implements CommandExecutor {

	private Main main;

	public Trash(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
			Inventory inv = main.getServer().createInventory(player, 27, "Müll");
			player.openInventory(inv);
			
		}
		
		
		return true;
	}

}
