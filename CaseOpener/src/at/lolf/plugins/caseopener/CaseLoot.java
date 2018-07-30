package at.lolf.plugins.caseopener;

import org.bukkit.inventory.ItemStack;


public class CaseLoot {
	public ItemStack[] normal;
	public ItemStack[] rare;
	public ItemStack legendary;
	
	CaseLoot(ItemStack[] normal, ItemStack[] rare, ItemStack legend){
		if(normal.length == 4 && rare.length == 2){
			this.normal = new ItemStack[4];
			this.rare = new ItemStack[2];
			
			
			this.normal = normal;
			this.rare = rare;
			this.legendary = legend;
		}else{
			System.out.println("Error creating CaseLoot. Loot must always contain 4 normal and 2 rare!!!!");
		}
	}
	
	
}
