package at.lolf.plugins.jumpandrun;

import java.util.HashMap;
import java.util.Map;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	private Warps warps;
	@SuppressWarnings("unused")
	private EndSigns end;
	public Map<String, Double> map;
	
	public FileConfiguration cfg;
	
	@Override
	public void onEnable() {
		System.out.println("loaded");
		cfg = getConfig();
		cfg.options().copyDefaults(true);
		
		warps = new Warps(this);
		end = new EndSigns(this);
		map = new HashMap<String, Double>();
		
		getCommand("jumpandrun").setExecutor(warps);
	}
	
	@Override
	public void onDisable() {
		System.out.println("unloaded");
		
		saveConfig();
	}
	
}
