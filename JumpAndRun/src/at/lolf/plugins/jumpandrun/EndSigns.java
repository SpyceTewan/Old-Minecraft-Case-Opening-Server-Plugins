package at.lolf.plugins.jumpandrun;


import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import at.lolf.plugins.points.Points;

public class EndSigns implements Listener {
	
	@SuppressWarnings("unused")
	private Main main;

	public EndSigns(Main main){
		this.main = main;
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("[jumpandrun]")){
			e.setLine(0, "§6[§2JumpAndRun§6]");
		}
	}
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		Player player = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getClickedBlock().getState() instanceof Sign){
				Sign sign = (Sign) e.getClickedBlock().getState();
				
				if(sign.getLine(0).equalsIgnoreCase("§6[§2JumpAndRun§6]")){
					Points.addPoints(player.getName(), Integer.parseInt(sign.getLine(3)));
					
					player.sendMessage("§2[§aJump and Run§2] §7Du hast das Jump And Run geschafft!");
					
					
					
					
					player.setHealth(0);
					player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 10);
				}
			}
		}
	}
}
