package at.lolf.plugins.cashout;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	BillSystem billSystem;
	
	
	@Override
	public void onEnable() {
		billSystem = new BillSystem(this);
		getCommand("cashout").setExecutor(billSystem);
		
		super.onEnable();
	}
	@Override
	public void onDisable() {
		
		super.onDisable();
	}
}
