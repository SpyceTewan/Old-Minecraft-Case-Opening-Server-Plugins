package at.lolf.plugins.cashout;



import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.lolf.plugins.points.Points;
import at.lolf.plugins.points.SidebarList;

public class BillSystem implements Listener, CommandExecutor{
	Main main;
	
	public BillSystem(Main main) {
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBillUse(PlayerInteractEvent e){
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			if(e.getPlayer().getItemInHand().getType() == Material.PAPER){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "§aGutschein" || e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == "&aGutschein"){
				
					List<String> list = e.getPlayer().getItemInHand().getItemMeta().getLore();
				int a = Integer.parseInt(list.get(0));
				Points.addPoints(e.getPlayer().getName(), a);
				SidebarList.updateSidebar(e.getPlayer());
				
				if(e.getPlayer().getItemInHand().getAmount() > 1){
				e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() - 1);
				}else{
				e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
				}
				
				e.getPlayer().updateInventory();
				e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
				}
			}
		}
	}
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			
			if(args.length == 1){
				
				try{
					
					Player p = ((Player) sender).getPlayer();
					ItemStack item = new ItemStack(Material.PAPER);
					
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§aGutschein");
					List<String> list = new ArrayList<String>();
					list.add(args[0]);
					meta.setLore(list);
					
					item.setItemMeta(meta);
					
					if(Integer.parseInt(args[0]) > 0 && Points.getPoints(p.getName()) >= Integer.parseInt(args[0])){
						
					
					p.getInventory().addItem(item);
					Points.removePoints(p.getName(), Integer.parseInt(args[0]));
					p.sendMessage("§2[§aCashout§2] §7Du hast dir einen Gutschein im Wert von §6" + args[0] + " §7ausgezahlt.");
					}else{
						p.sendMessage("§2[§aCashout§2] §cDu hast nicht genug Geld oder dein Betrag in negativ");
					}
					
					return true;
					
				}catch(Exception e){
					return false;
				}
			}
			
		}
		return false;
	}
}
