package at.lolf.plugins.sellui;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ValueManager {
	private static File file;
	private static FileConfiguration cfg;
	public static HashMap<Integer, Integer> VALUES;
	
	ValueManager(Main main){
	file = new File(main.getDataFolder().getPath(), "values.yml");
	cfg = YamlConfiguration.loadConfiguration(file);
	
	VALUES = new HashMap<Integer, Integer>();
	}
	
	public static void init(){
		for(int i = 0; i < 405; i++){
			int v = 0;
			try{
				v = (int) cfg.getInt("" + i);
			}catch(Exception e){
				
			}
			VALUES.put(i, v);
		}
	}
	
}
