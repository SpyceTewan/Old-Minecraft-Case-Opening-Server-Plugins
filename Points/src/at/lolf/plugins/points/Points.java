package at.lolf.plugins.points;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Points extends JavaPlugin{
	
	private static FileConfiguration cfg;
	
	@SuppressWarnings("deprecation")
	public static void addPoints(String player, int points){
		cfg.set("Points." + player, points  + cfg.getInt("Points." + player));
		SidebarList.updateSidebar(Bukkit.getPlayer(player));
	}
	
	@SuppressWarnings("deprecation")
	public static void setPoints(String player, int points){
		cfg.set("Points." + player, points);
		SidebarList.updateSidebar(Bukkit.getPlayer(player));
	}
	
	@SuppressWarnings("deprecation")
	public static void removePoints(String player, int points){
		cfg.set("Points." + player, cfg.getInt("Points." + player) - points);
		SidebarList.updateSidebar(Bukkit.getPlayer(player));
	}
	
	public static int getPoints(String player){
		
		return cfg.getInt("Points." + player);
	}
	
	SidebarList list;
	Economy eco;
	
	@Override
	public void onEnable() {
		cfg = getConfig();
		
		System.out.println("Config geladen!");
		
		cfg.options().copyDefaults(true);
		saveConfig();
		
		eco = new Economy();
		list = new SidebarList();
		list.init(this);
		
		getCommand("eco").setExecutor(eco);
		getCommand("points").setExecutor(this);
		
		
	}
	
	@Override
	public void onDisable() {
		saveConfig();
		
		System.out.println("Config gespeichert!");
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("savepoints") && sender.hasPermission("points.saveconfig")){
			saveConfig();
			sender.sendMessage("§2Config gespeichert!");
			
			return true;
		}
		
		
		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("points")){
			Player player = ((Player) sender).getPlayer();
			
			player.sendMessage("§2Dein Geld: §6" + getPoints(player.getName()));
			
			return true;
		}
		
		
		return false;
	}
}
