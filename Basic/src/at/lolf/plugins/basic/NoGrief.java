package at.lolf.plugins.basic;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoGrief implements Listener {
	

	@SuppressWarnings("unused")
	private Main main;

	public NoGrief(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("plot")){
		if(e.getPlayer().hasPermission(Permlist.BLOCK) && e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		}
	}
	@EventHandler
	public void onBucket(PlayerBucketEmptyEvent e){
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("plot")){
		if(e.getPlayer().hasPermission(Permlist.BLOCK) && e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		}
	}
	@EventHandler
	public void onBucket(PlayerBucketFillEvent e){
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("plot")){
	
		if(e.getPlayer().hasPermission(Permlist.BLOCK) && e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		}
	}
	@EventHandler
	public void onBoat(PlayerInteractEvent e){
		if(e.getPlayer().getItemInHand().getType() == Material.BOAT){
		
		if(e.getPlayer().hasPermission(Permlist.BLOCK) && e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("plot")){
	
		if(e.getPlayer().hasPermission(Permlist.BLOCK) && e.getPlayer().getGameMode() == GameMode.CREATIVE){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		}
	}
}
