package at.lolf.plugins.basic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Spawn spawn;
	private static Gamemode gamemode;
	
	@SuppressWarnings("unused")
	private static NoGrief nogrief;
	
	@SuppressWarnings("unused")
	private static EventManager events;
	private static ItemRenamer renamer;
	private static Feed feed;
	private static Heal heal;
	private static Trash trash;
	private static Fly fly;
	
	private static PlotTP plottp;
	
	public static FileConfiguration cfg;
	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		System.out.println("[Basic] Loaded!");
		
		cfg = getConfig();
		cfg.options().copyDefaults(true);
		
		spawn = new Spawn(this);
		gamemode = new Gamemode(this);
		nogrief = new NoGrief(this);
		events = new EventManager(this);
		renamer = new ItemRenamer(this);
		feed = new Feed(this);
		heal = new Heal(this);
		trash = new Trash(this);
		fly = new Fly(this);
		plottp = new PlotTP(this);
		
		getCommand("spawn").setExecutor(spawn);
		getCommand("setspawn").setExecutor(spawn);
		getCommand("gm").setExecutor(gamemode);
		getCommand("rename").setExecutor(renamer);
		getCommand("feed").setExecutor(feed);
		getCommand("heal").setExecutor(heal);
		getCommand("trash").setExecutor(trash);
		getCommand("fly").setExecutor(fly);
		getCommand("plottp").setExecutor(plottp);
		
		
		
		saveConfig();
		
		float pitch = (float) cfg.getDouble("Spawn.pitch");
		float yaw = (float) cfg.getDouble("Spawn.yaw");
		spawn.SPAWN = new Location(Bukkit.getWorld((String) cfg.getString("Spawn.world")), cfg.getDouble("Spawn.x"), cfg.getDouble("Spawn.y"), cfg.getDouble("Spawn.z"), yaw, pitch);
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Basic] Unloaded!");
		
		
		saveConfig();
	}
}
