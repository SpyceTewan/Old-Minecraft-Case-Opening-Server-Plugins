package at.lolf.plugins.caseopener;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;



public class Market implements Listener {
	
	
	public Market(Main main){
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		
		
		if(e.getClickedBlock().equals(Material.SIGN)){
			
			Sign sign = (Sign) e.getClickedBlock();
			if(sign.getLine(1) == "[Market]"){
				
				if(e.getAction() == Action.LEFT_CLICK_BLOCK){
					if(Points.getPoints(e.getPlayer().getName()) >= Integer.parseInt(sign.getLine(2))){
						Points.removePoints(e.getPlayer().getName(), Integer.parseInt(sign.getLine(2)));
						e.getPlayer().getInventory().addItem(new ItemStack(Integer.parseInt(sign.getLine(3))));
					}else{
						e.getPlayer().sendMessage("§2Du hast zu wenig Geld");
					}
				}
				
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
					if(e.getPlayer().getInventory().contains(Integer.parseInt(sign.getLine(3)))){
						Points.addPoints(e.getPlayer().getName(), Integer.parseInt(sign.getLine(2)));
						e.getPlayer().getInventory().remove(Integer.parseInt(sign.getLine(3)));
					}else{
						e.getPlayer().sendMessage("§2Du hast dieses Item nicht!");
					}
				}
				SidebarList.updateSidebar(e.getPlayer());
			}
		}
		
		
	}
	
	
	
}
