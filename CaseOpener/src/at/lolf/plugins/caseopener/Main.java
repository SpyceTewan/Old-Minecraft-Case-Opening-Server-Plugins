package at.lolf.plugins.caseopener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@SuppressWarnings("unused")
	private Farmer farmer;
	private Shop shop;
	private CaseSystem caseSystem;
	private Tools tools;
	private Help help;
	private static CaseCfgManager cfgManager;
	
	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		farmer = new Farmer(this);
		shop = new Shop(this);
		caseSystem = new CaseSystem();
		caseSystem.init(this);
		tools = new Tools(this);
		help = new Help(this);
		cfgManager = new CaseCfgManager(this);
		cfgManager.initiateCases();
		
		
		getCommand("cases").setExecutor(shop);
		getCommand("tools").setExecutor(tools);
		getCommand("cmd").setExecutor(help);
		
		
		
		
		System.out.println("[CaseOpener] Enabled");
	}
	@Override
	public void onDisable() {
		System.out.println("[CaseOpener] Disabled");
	}
	
	
}
