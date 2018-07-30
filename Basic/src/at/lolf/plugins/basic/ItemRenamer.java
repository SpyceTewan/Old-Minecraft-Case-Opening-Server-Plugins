package at.lolf.plugins.basic;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemRenamer implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main main;

	public ItemRenamer(Main main){
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			if(player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR && arg[0] != null && player.hasPermission(Permlist.RENAME)){
				
				ItemMeta meta = player.getItemInHand().getItemMeta();
				meta.setDisplayName(arg[0].toString().replace("&", "§") + arg[1] + arg[2] + arg[3] + arg[4] + arg[5]);
				player.getItemInHand().setItemMeta(meta);
				
			}
			
			return true;
		}
		
		return false;
	}
}
