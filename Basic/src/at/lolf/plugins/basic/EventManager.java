package at.lolf.plugins.basic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventManager implements Listener {
	
	
	private Main main;

	public EventManager(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage("§6" + e.getPlayer().getDisplayName() + " §2hat den Server betreten");
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		e.setQuitMessage("§6" + e.getPlayer().getDisplayName() + " §2hat den Server verlassen");
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e){
		e.setReason("§2Du wurdest vom Server geworfen! §eGrund: §c" + e.getReason());
		e.setLeaveMessage("§2" + e.getPlayer() + " wurde vom Server geworfen! &eGrund: §c" + e.getReason());
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		if(e.getPlayer().hasPermission(Permlist.DROP)){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		
		float pitch = (float) main.cfg.getDouble("Spawn.pitch");
		
		float yaw = (float) main.cfg.getDouble("Spawn.yaw");
		
		
		
		Location tp = new Location(Bukkit.getWorld((String) main.cfg.getString("Spawn.world")), main.cfg.getDouble("Spawn.x"), main.cfg.getDouble("Spawn.y"), main.cfg.getDouble("Spawn.z"), yaw, pitch);
		
		
		
		e.setRespawnLocation(tp);
	}
	
	
}
