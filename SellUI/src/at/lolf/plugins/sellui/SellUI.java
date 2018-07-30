package at.lolf.plugins.sellui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;

public class SellUI implements Listener{
	
	Inventory inv;
	Player p;
	Main main;
	int value;
	
	public SellUI(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	public void openMenu(Player player){
		p = player;
		inv = Bukkit.createInventory(player, 27, "Verkaufen");
		
		
		player.openInventory(inv);
	}
	
	
	
	@EventHandler
	public void onMenuClose(InventoryCloseEvent e){
		if(e.getInventory().getTitle() == "Verkaufen"){
			scanInventory();
			
			Points.addPoints(e.getPlayer().getName(), value);
			SidebarList.updateSidebar((Player) e.getPlayer());
			e.getPlayer().sendMessage("§2[§aSellUI§2] §7Du hast deine Items für §c" + value + " §7verkauft");
			
		}
	}
	
	
	@SuppressWarnings("deprecation")
	private void scanInventory(){
		int v = 0;
		
		for(int i = 0; i < 27; i++){
			if(inv.getItem(i) != null){
			v += ValueManager.VALUES.get(inv.getItem(i).getTypeId()) * inv.getItem(i).getAmount();
			}
		}
	
		value = v;
		
	}
	
	
}
