package at.lolf.plugins.caseopener;

import org.bukkit.inventory.ItemStack;

public class Case {
	private String name;
	private String desc;
	private CaseLoot loot;
	private int type;
	private int price;
	
	Case(String name, String description, CaseLoot loot, int type, int price) {
	
		this.name = name;
		this.desc = description;
		this.loot = loot;
		this.type = type;
		this.price = price;
		
	}
	
	public String getName(){
		return name;
	}
	public String getDescription(){
		return desc;
	}
	public CaseLoot getLoot(){
		return loot;
	}
	public int getType(){
		return type;
	}
	public int getPrice(){
		return price;
	}
	public ItemStack[] getItemNormal(){
		return loot.normal;
	}
	public ItemStack[] getItemRare(){
		return loot.rare;
	}
	public ItemStack getItemLegendary(){
		return loot.legendary;
	}
}
