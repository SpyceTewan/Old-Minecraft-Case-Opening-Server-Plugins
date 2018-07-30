package at.lolf.plugins.caseopener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;

public class Farmer implements Listener {
	

	public Farmer(Main main){
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("plot")){
		
		if(e.getBlock().getType() == Material.COAL_BLOCK){
			if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
				e.setCancelled(true);
				
				if(e.getPlayer().getItemInHand().getDurability() < e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
				}else if(e.getPlayer().getItemInHand().getDurability() >= e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR));
				}
				
				Points.addPoints(e.getPlayer().getName(), 1);
			
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHICKEN_EGG_POP, 1, 1.5F);
				
				
				SidebarList.updateSidebar(e.getPlayer());
				e.getPlayer().updateInventory();
				
			}
			if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
			}
		}
		if(e.getBlock().getType() == Material.OBSIDIAN){
			if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
				
				if(e.getPlayer().getItemInHand().getDurability() < e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
				}else if(e.getPlayer().getItemInHand().getDurability() >= e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR));
				}
				
				Points.addPoints(e.getPlayer().getName(), 5);
			
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHICKEN_EGG_POP, 1, 1.5F);
				
				
				SidebarList.updateSidebar(e.getPlayer());
				
				e.setCancelled(true);
			}
			if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
			}
		}
		
		
		if(e.getBlock().getType() == Material.LOG){
			if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
				
				if(e.getPlayer().getItemInHand().getDurability() < e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
				}else if(e.getPlayer().getItemInHand().getDurability() >= e.getPlayer().getItemInHand().getType().getMaxDurability()){
					e.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR));
				}
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHICKEN_EGG_POP, 1, 1.5F);
				e.getPlayer().getInventory().addItem(new ItemStack(Material.WOOD));
				
				e.setCancelled(true);
			}else if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
				e.setCancelled(false);
			}
		}
		}
	}
}
