package at.lolf.plugins.sellui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	SellUI sellui;
	ValueManager valuemanager;
	Prices prices;
	
	@Override
	public void onEnable() {
		
		
		
		sellui = new SellUI(this);
		valuemanager = new ValueManager(this);
		prices = new Prices(this);
		ValueManager.init();
		
		getCommand("sell").setExecutor(this);
		getCommand("prices").setExecutor(prices);
		
		super.onEnable();
	}
	@Override
	public void onDisable() {
		
		super.onDisable();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			sellui.openMenu((Player) sender);
			return true;
		}
		
		return false;
	}
}
