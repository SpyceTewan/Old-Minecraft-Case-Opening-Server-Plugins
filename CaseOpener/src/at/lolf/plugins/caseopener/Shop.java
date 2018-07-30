package at.lolf.plugins.caseopener;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;




public class Shop implements CommandExecutor, Listener {

	private Main main;
	private Inventory menu;
	
	public Shop(Main main) {
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
		
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
			if(cmd.getName().equalsIgnoreCase("cases")){
				
				int n = CaseDB.CASES.size();
				
				int rows = 1;
				if(n > 9){
					rows = 2;
				}
				if(n > 18){
					rows = 3;
				}
				if(n > 27){
					rows = 4;
				}
				if(n > 36){
					rows = 5;
				}
				if(n > 54){
					rows = 6;
				}
				
				menu = main.getServer().createInventory(player, rows * 9, "Cases");
				
				for(int i = 0; i < n; i++){
					Case ca = CaseDB.CASES.get(i);
					ItemStack item = null;
					
					
					if(ca.getType() == 0){
						item = new ItemStack(Material.CHEST);
					}else
					if(ca.getType() == 1){
						item = new ItemStack(Material.ENDER_CHEST);
					}
					if(ca.getType() == 2){
						item = new ItemStack(Material.NOTE_BLOCK);
					}
					
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(ca.getName());
					List<String> list = new ArrayList<String>();
					
					list.add("§2Preis: " + ca.getPrice());
					list.add("§2===============");
					list.add("§6" + ca.getItemLegendary().getType());
					list.add("§c" + ca.getItemRare()[0].getType());
					list.add("§c" + ca.getItemRare()[1].getType());
					list.add("§a" + ca.getItemNormal()[0].getType());
					list.add("§a" + ca.getItemNormal()[1].getType());
					list.add("§a" + ca.getItemNormal()[2].getType());
					list.add("§a" + ca.getItemNormal()[3].getType());
					list.add("§2===============");
					list.add("§2" + ca.getDescription());
					
					meta.setLore(list);
					item.setItemMeta(meta);
					
					menu.addItem(item);
				}
				

				
				player.openInventory(menu);
			}
		}
		
		
		return true;
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent e){
		if(e.getInventory().getName() == "Cases"){
			e.setCancelled(true);
			
			
			if(CaseDB.isCase(e.getCurrentItem().getItemMeta().getDisplayName())){
				
				Case ca = CaseDB.getChestByName(e.getCurrentItem().getItemMeta().getDisplayName());
				
				if(Points.getPoints(e.getWhoClicked().getName()) >= ca.getPrice()){
					Points.removePoints(e.getWhoClicked().getName(), ca.getPrice());
					
					
					ItemStack item = null;
					
					if(ca.getType() == 0){
						item = new ItemStack(Material.CHEST);
					}else
					if(ca.getType() == 1){
						item = new ItemStack(Material.ENDER_CHEST);
					}
					if(ca.getType() == 2){
						item = new ItemStack(Material.NOTE_BLOCK);
					}
					
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(ca.getName());
					List<String> list = new ArrayList<String>();
					
					list.add("§2Preis: " + ca.getPrice());
					list.add("§2===============");
					list.add("§2" + ca.getDescription());
					
					meta.setLore(list);
					item.setItemMeta(meta);
					
					
					
					e.getWhoClicked().getInventory().addItem(item);
					SidebarList.updateSidebar((Player)e.getWhoClicked());
					e.getWhoClicked().sendMessage("§2Du hast dir " + ca.getName() + "§n§2 um " + ca.getPrice() + " gekauft.");
				}else{
					e.getWhoClicked().sendMessage("§cDu hast nicht genug Geld um " + ca.getName() + "§n§c zu kaufen.");
				}
				
			}
		}
	}
	
	
	
	
	
}
