package at.lolf.plugins.caseopener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;

	public Help(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		sender.sendMessage("§2/tools §6- Öffnet den Spitzhackenshop!");
		sender.sendMessage("§2/cases §6- Öffnet den Kistenshop!");
		sender.sendMessage("§2/map <mapname> §6- Teleportiert dich in eine PvP Arena");
		sender.sendMessage("§2================================");
		sender.sendMessage("§2Bei weiteren Fragen einfach das Team anschreiben!");
		
		return true;
	}

}
