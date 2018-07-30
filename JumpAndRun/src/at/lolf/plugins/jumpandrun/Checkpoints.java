package at.lolf.plugins.jumpandrun;



import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Checkpoints implements Listener {
	
	private Main main;

	public Checkpoints(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public void onPressurePlateStep(PlayerInteractEvent e){
		if(e.getAction() == Action.PHYSICAL && e.getMaterial() == Material.IRON_PLATE && e.getPlayer().getWorld() == Bukkit.getWorld("Jar")){
			Player player = e.getPlayer();
			
			main.map.put(player.getName() + "x", player.getLocation().getX());
			main.map.put(player.getName() + "y", player.getLocation().getY());
			main.map.put(player.getName() + "z", player.getLocation().getZ());
			main.map.put(player.getName() + "pitch", Double.parseDouble(player.getLocation().getPitch() + ""));
			main.map.put(player.getName() + "yaw", Double.parseDouble(player.getLocation().getYaw() + ""));
		}
	}
	
	
	
}