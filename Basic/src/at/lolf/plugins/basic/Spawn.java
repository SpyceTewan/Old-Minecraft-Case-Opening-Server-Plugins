package at.lolf.plugins.basic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Spawn implements CommandExecutor, Listener {
	
	private Main main;
	
	public static Location SPAWN;

	@SuppressWarnings("static-access")
	public Spawn(Main main) {
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
		
		float pitch = (float) main.cfg.getDouble("Spawn.pitch");
		float yaw = (float) main.cfg.getDouble("Spawn.yaw");
		
		SPAWN = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
		
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
				if(cmd.getName().equalsIgnoreCase("spawn")){
				
				
				player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 2, 1.5F);
				
				
				float pitch = (float) main.cfg.getDouble("Spawn.pitch");
				float yaw = (float) main.cfg.getDouble("Spawn.yaw");
				
				Location tp = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
				
				player.teleport(tp);
				
			}
			
			if(cmd.getName().equalsIgnoreCase("setspawn")){
				if(player.hasPermission(Permlist.SPAWN_SET)){
					double x = player.getLocation().getX();
					double y = player.getLocation().getY();
					double z = player.getLocation().getZ();
					float pitch = player.getLocation().getPitch();
					float yaw = player.getLocation().getYaw();
					String world = player.getWorld().getName();
					
					main.cfg.set("Spawn.x", x);
					main.cfg.set("Spawn.y", y);
					main.cfg.set("Spawn.z", z);
					main.cfg.set("Spawn.pitch", pitch);
					main.cfg.set("Spawn.yaw", yaw);
					main.cfg.set("Spawn.world", world);
					
					
					player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
					main.getServer().setSpawnRadius(0);
					main.getServer().useExactLoginLocation();
					
					
					player.sendMessage("§2[§aBasic§2] §7Spawn gesetzt");
					
					
					
					SPAWN = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		@SuppressWarnings("static-access")
		float pitch = (float) main.cfg.getDouble("Spawn.pitch");
		@SuppressWarnings("static-access")
		float yaw = (float) main.cfg.getDouble("Spawn.yaw");
		
		@SuppressWarnings("static-access")
		Location tp = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
		e.getPlayer().teleport(tp);
	}
	
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		@SuppressWarnings("static-access")
		float pitch = (float) main.cfg.getDouble("Spawn.pitch");
		@SuppressWarnings("static-access")
		float yaw = (float) main.cfg.getDouble("Spawn.yaw");
		
		@SuppressWarnings("static-access")
		Location tp = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
		e.getPlayer().teleport(tp);
	}
}
