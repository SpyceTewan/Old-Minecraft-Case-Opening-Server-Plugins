package at.lolf.plugins.points;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class SidebarList {
	
	
	
	public void init(Points main){
	}
	
	public static void updateSidebar(Player player){
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("a", "b");
		obj.setDisplayName("§dtewan.diem.cl");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		
		
		@SuppressWarnings("deprecation")
		Score one = obj.getScore(Bukkit.getOfflinePlayer("§dGeld§5: §e" + Points.getPoints(player.getName())));
		@SuppressWarnings("deprecation")
		Score two = obj.getScore(Bukkit.getOfflinePlayer("§dHilfe§5: §e/cmd"));
		
		one.setScore(1);
		two.setScore(0);
		
		
		player.setScoreboard(board);
	}

}
