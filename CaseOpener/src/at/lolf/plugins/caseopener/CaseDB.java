package at.lolf.plugins.caseopener;

import java.util.ArrayList;


public class CaseDB {
	
	public static ArrayList<Case> CASES = new ArrayList<Case>();
	
	
	public static Case getChestByName(String name){
		Case a = null;
		for(Case ca : CASES){
			if(ca.getName().equalsIgnoreCase(name)){
				a = ca;
			}
		}
		if(a != null){
			return a;
		}else{
			return null;
		}
	}
	
	public static boolean isCase(String name){
		boolean sucess = false;
		for(Case ca : CASES){
			if(ca.getName().equalsIgnoreCase(name)){
				sucess = true;
				break;
			}
		}
		
		return sucess;
	}
}
