package at.lolf.plugins.caseopener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;

public class Tools implements CommandExecutor, Listener{

	
	private Main main;
	
	private Inventory menu;
	private static File file;
	private static FileConfiguration cfg;
	
	int PREIS_STONE = 100;
	int PREIS_IRON = 400;	
	int PREIS_GOLD = 600;
	int PREIS_DIA = 1000;
	

	public Tools(Main main) {
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
		file = new File(main.getDataFolder().getPath(), "tools.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
		
		PREIS_STONE = (int) cfg.get("Prices.Stone_Pickaxe");
		PREIS_IRON = (int) cfg.get("Prices.Iron_Pickaxe");
		PREIS_GOLD = (int) cfg.get("Prices.Gold_Pickaxe");
		PREIS_DIA = (int) cfg.get("Prices.Diamond_Pickaxe");
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		if(sender instanceof Player){
			Player player = ((Player) sender).getPlayer();
			
			
			if(cmd.getName().equalsIgnoreCase("tools")){
				
				
				menu = main.getServer().createInventory(player, 27, "Tools");
				
				//Holz Pickaxe
				ItemStack wood = new ItemStack(Material.WOOD_PICKAXE);
				ItemMeta woodmeta = wood.getItemMeta();
				woodmeta.setDisplayName("§9§lSpitzhacke");
				
				List<String> woodlore = new ArrayList<String>();
				woodlore.add("§6Preis: §c0");
				woodmeta.setLore(woodlore);
				wood.setItemMeta(woodmeta);
				
				
				
				//Stone Pickaxe
				ItemStack stone = new ItemStack(Material.STONE_PICKAXE);
				ItemMeta stonemeta = stone.getItemMeta();
				stonemeta.setDisplayName("§5§lSpitzhacke");
				
				List<String> stonelore = new ArrayList<String>();
				stonelore.add("§6Preis: §c" + PREIS_STONE);
				stonemeta.setLore(stonelore);
				stone.setItemMeta(stonemeta);
				
				
				
				//Iron Pickaxe
				ItemStack iron = new ItemStack(Material.IRON_PICKAXE);
				ItemMeta ironmeta = iron.getItemMeta();
				ironmeta.setDisplayName("§d§lSpitzhacke");
				
				List<String> ironlore = new ArrayList<String>();
				ironlore.add("§6Preis: §c" + PREIS_IRON);
				ironmeta.setLore(ironlore);
				iron.setItemMeta(ironmeta);
				
				
				
				//Gold Pickaxe
				ItemStack gold = new ItemStack(Material.GOLD_PICKAXE);
				ItemMeta goldmeta = gold.getItemMeta();
				goldmeta.setDisplayName("§4§lSpitzhacke");
				
				List<String> goldlore = new ArrayList<String>();
				goldlore.add("§6Preis: §c" + PREIS_GOLD);
				goldmeta.setLore(goldlore);
				gold.setItemMeta(goldmeta);
				
				
				
				//Diamond Pickaxe
				ItemStack diamond = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta diamondmeta = diamond.getItemMeta();
				diamondmeta.setDisplayName("§6§lSpitzhacke");
				
				List<String> diamondlore = new ArrayList<String>();
				diamondlore.add("§6Preis: §c" + PREIS_DIA);
				diamondmeta.setLore(diamondlore);
				diamond.setItemMeta(diamondmeta);
				
				
				
				
				//Setze Item ins das Inv
				menu.setItem(11, wood);
				menu.setItem(12, stone);
				menu.setItem(13, iron);
				menu.setItem(14, gold);
				menu.setItem(15, diamond);
				
				player.openInventory(menu);
			}
			
			return true;
		}
		return false;
	}
	
	
	@EventHandler
	public void invClick(InventoryClickEvent e){
		if(e.getInventory().getName().equals("Tools")){
			if(e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR){
					if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§9§lSpitzhacke")){
						
			
						ItemStack item = new ItemStack(Material.WOOD_PICKAXE);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName("§9Spitzhacke");
						item.setItemMeta(meta);
			
						e.getWhoClicked().getInventory().addItem(item);
			
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lSpitzhacke")){
						
			
						if(Points.getPoints(e.getWhoClicked().getName()) >= PREIS_STONE){
							Points.removePoints(e.getWhoClicked().getName(), PREIS_STONE);
							
							ItemStack item = new ItemStack(Material.STONE_PICKAXE);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§5Spitzhacke");
							item.setItemMeta(meta);
							e.getWhoClicked().getInventory().addItem(item);
						}else{
							e.getWhoClicked().sendMessage("§2Du hast zu wenig Geld");
						}
			
			
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§d§lSpitzhacke")){
						
						if(Points.getPoints(e.getWhoClicked().getName()) >= PREIS_IRON){
							Points.removePoints(e.getWhoClicked().getName(), PREIS_IRON);
							
							ItemStack item = new ItemStack(Material.IRON_PICKAXE);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§dSpitzhacke");
							item.setItemMeta(meta);
							e.getWhoClicked().getInventory().addItem(item);
						}else{
							e.getWhoClicked().sendMessage("§2Du hast zu wenig Geld");
						}
			
			
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§lSpitzhacke")){
						
						
						if(Points.getPoints(e.getWhoClicked().getName()) >= PREIS_GOLD){
							Points.removePoints(e.getWhoClicked().getName(), PREIS_GOLD);
			
							ItemStack item = new ItemStack(Material.GOLD_PICKAXE);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§4Spitzhacke");
							item.setItemMeta(meta);
							e.getWhoClicked().getInventory().addItem(item);
						}else{
							e.getWhoClicked().sendMessage("§2Du hast zu wenig Geld");
						}
						
						
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lSpitzhacke")){
						
						
						if(Points.getPoints(e.getWhoClicked().getName()) >= PREIS_GOLD){
							Points.removePoints(e.getWhoClicked().getName(), PREIS_DIA);
							
							ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§6Spitzhacke");
							item.setItemMeta(meta);
							e.getWhoClicked().getInventory().addItem(item);
						}else{
							e.getWhoClicked().sendMessage("§2Du hast zu wenig Geld");
						}
						
						
						
					}
				
			}
			SidebarList.updateSidebar((Player)e.getWhoClicked());
			e.setCancelled(true);
		}
		
	}
}
