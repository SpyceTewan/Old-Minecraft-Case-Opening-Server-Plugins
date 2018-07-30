package at.lolf.plugins.sellui;



import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;



public class Prices implements CommandExecutor {

	Main main;
	
	public Prices(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("prices")){
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta meta = (BookMeta) item.getItemMeta();
			meta.setAuthor("Server");
			meta.setDisplayName("Preisliste");
			meta.setTitle("Preisliste");
			
			
			for(int i = 0; i < 405; i++){
				
				meta.addPage(
						"§2" + Material.getMaterial(i) + ": §c" + ValueManager.VALUES.get(i ) + "\n" +
						"§2" + Material.getMaterial(i + 1) + ": §c" + ValueManager.VALUES.get(i + 1) + "\n" +
						"§2" + Material.getMaterial(i + 2) + ": §c" + ValueManager.VALUES.get(i + 2) + "\n" +
						"§2" + Material.getMaterial(i + 3) + ": §c" + ValueManager.VALUES.get(i + 3) + "\n" +
						"§2" + Material.getMaterial(i + 4) + ": §c" + ValueManager.VALUES.get(i + 4) + "\n" +
						"§2" + Material.getMaterial(i + 5) + ": §c" + ValueManager.VALUES.get(i + 5) + "\n" +
						"§2" + Material.getMaterial(i + 6) + ": §c" + ValueManager.VALUES.get(i + 6) + "\n" +
						"§2" + Material.getMaterial(i + 7) + ": §c" + ValueManager.VALUES.get(i + 7) + "\n" +
						"§2" + Material.getMaterial(i + 8) + ": §c" + ValueManager.VALUES.get(i + 8) + "\n" +
						"§2" + Material.getMaterial(i + 9) + ": §c" + ValueManager.VALUES.get(i + 9) + "\n" +
						"§2" + Material.getMaterial(i + 10) + ": §c" + ValueManager.VALUES.get(i + 10) + "\n" +
						"§2" + Material.getMaterial(i + 11) + ": §c" + ValueManager.VALUES.get(i + 11) + "\n" +
						"§2" + Material.getMaterial(i + 12) + ": §c" + ValueManager.VALUES.get(i + 12));
				i += 12;
			}
			
			
			item.setItemMeta(meta);
			Player p = ((Player) sender);
			p.getInventory().addItem(item);
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 2, 1);
			return true;
		}
		
		return false;
	}

}
