package at.lolf.plugins.caseopener;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class CaseSystem implements Listener{
	
	@SuppressWarnings("unused")
	private static Main main;
	
	@SuppressWarnings("static-access")
	public void init(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public static void openEvent(PlayerInteractEvent e){
		
		if(e.getMaterial() == Material.CHEST || e.getMaterial() == Material.ENDER_CHEST || e.getMaterial() == Material.NOTE_BLOCK){
			
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
				if(CaseDB.isCase(e.getPlayer().getItemInHand().getItemMeta().getDisplayName())){
					openCase(e.getPlayer(), CaseDB.getChestByName(e.getPlayer().getItemInHand().getItemMeta().getDisplayName()));
				}
			
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void openCase(Player p, Case ca){
		
		double rnd = Math.random() * 7;
		ItemStack item;
		
		if(rnd < 7 * 0.05){
			item = ca.getLoot().legendary;
			p.sendMessage("§2[" + ca.getName() + "§2]§f: §6LEGENDARY!!!!!");
		}else if(rnd < 7 * 0.2){
			item = ca.getLoot().rare[(int) (Math.random() * 2)];
			p.sendMessage("§2[" + ca.getName() + "§2]§f: §cRare!!");
		}else{
			item = ca.getLoot().normal[(int) (Math.random() * 4)];
			p.sendMessage("§2[" + ca.getName() + "§2]§f: §7Normal");
		}
		
		p.getInventory().addItem(item);
		
		p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1f, 1.5f);
		
		if(p.getInventory().getItemInHand().getAmount() == 1){
			p.getInventory().setItemInHand(new ItemStack(Material.AIR));
		}else{
			p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
		}
		p.updateInventory();
		
	}
	
}
