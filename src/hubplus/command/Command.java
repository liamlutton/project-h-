package hubplus.command;

import org.bukkit.entity.Player;

public abstract class Command {

	private String name, description, permission;
	
	public Command(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	protected void setPermission(String permission){
		this.permission = permission;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public String getPermission(){
		return this.permission;
	}
	
	public abstract void run(Player sender);
	
}
