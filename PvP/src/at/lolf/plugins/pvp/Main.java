package at.lolf.plugins.pvp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	private Warps warps;
	
	
	
	public FileConfiguration cfg;
	
	@Override
	public void onEnable() {
		System.out.println("loaded");
		cfg = getConfig();
		cfg.options().copyDefaults(true);
		
		warps = new Warps(this);
		
		
		
		getCommand("map").setExecutor(warps);
	}
	
	@Override
	public void onDisable() {
		System.out.println("loaded");
		
		saveConfig();
	}
	

}
