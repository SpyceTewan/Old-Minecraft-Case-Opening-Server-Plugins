package at.lolf.plugins.caseopener;

import java.io.File;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class CaseCfgManager {
	
	static Main main;
	
	@SuppressWarnings("static-access")
	CaseCfgManager(Main main){
		this.main = main;
		file = new File(main.getDataFolder().getPath(), "cases.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
	}
	
	private static File file;
	private static FileConfiguration cfg;
	
	
	@SuppressWarnings({ "deprecation" })
	public static void initiateCases(){
		
		
		for(int i = 0; i < cfg.getInt("CaseAmount"); i++){
		
		ItemStack[] normals = new ItemStack[4];
		ItemStack[] rares = new ItemStack[2];
		ItemStack legendary;
		Integer d;
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Normal.I0.Damage"));
		normals[0] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Normal.I0.ID"), (int) cfg.get("Case" + i + ".Loot.Normal.I0.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Normal.I1.Damage"));
		normals[1] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Normal.I1.ID"), (int) cfg.get("Case" + i + ".Loot.Normal.I1.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Normal.I2.Damage"));
		normals[2] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Normal.I2.ID"), (int) cfg.get("Case" + i + ".Loot.Normal.I2.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Normal.I3.Damage"));
		normals[3] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Normal.I3.ID"), (int) cfg.get("Case" + i + ".Loot.Normal.I3.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Rare.I0.Damage"));
		rares[0] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Rare.I0.ID"), (int) cfg.get("Case" + i + ".Loot.Rare.I0.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Rare.I1.Damage"));
		rares[1] = new ItemStack((int) cfg.get("Case" + i + ".Loot.Rare.I1.ID"), (int) cfg.get("Case" + i + ".Loot.Rare.I1.Amount"), d.shortValue());
		
		d = new Integer((int) cfg.getInt("Case" + i + ".Loot.Legendary.Damage"));
		legendary = new ItemStack((int) cfg.get("Case" + i + ".Loot.Legendary.ID"), (int) cfg.get("Case" + i + ".Loot.Legendary.Amount"), d.shortValue());
		CaseLoot loot = new CaseLoot(normals, rares, legendary);
		
		CaseDB.CASES.add(new Case("§n§e" +
				cfg.getString("Case" + i + ".Name"), 
				cfg.getString("Case" + i + ".Description"), loot, 
				(int) cfg.get("Case" + i + ".Type"), 
				(int) cfg.get("Case" + i + ".Price") ));
		
		System.out.println("Added Case " + cfg.getString("Case" + i + ".Name"));
		}
	}
}
