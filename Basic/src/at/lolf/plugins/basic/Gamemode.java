package at.lolf.plugins.basic;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Gamemode implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;

	public Gamemode(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
			
		if(sender instanceof Player){
			
			Player player = ((Player) sender).getPlayer();
			
			if(player.hasPermission(Permlist.GAMEMODE)){
				String target;
				
				if(arg.length <= 1){
					target = player.getName();
				}else{
					target = Bukkit.getPlayer(arg[1]).getName();
				}
				
				
				if(arg[0].equals("0")){
					Bukkit.getPlayer(target).setGameMode(GameMode.SURVIVAL);
				}else if(arg[0].equals("1")){
					Bukkit.getPlayer(target).setGameMode(GameMode.CREATIVE);
				}else if(arg[0].equals("2")){
					Bukkit.getPlayer(target).setGameMode(GameMode.ADVENTURE);
				}else if(arg[0].equals("3")){
					Bukkit.getPlayer(target).setGameMode(GameMode.SPECTATOR);
				}
				player.sendMessage("§2[§aBasic§2] §6" + target + " §7ist nun im Gamemode §6" + Bukkit.getPlayer(target).getGameMode());
				
			}
			
			
		}
		return true;
	}
	
	
	
}
