package hubplus.core;

import hubplus.command.CommandManager;
import hubplus.worlds.WorldManager;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class HubPlus extends JavaPlugin {

	private static HubPlus instance;
	
	private CommandManager commandManager;
	private WorldManager worldManager;
	
	private ChatColor mainColor = ChatColor.LIGHT_PURPLE;
	private ChatColor secondaryColor = ChatColor.GRAY;
	
	@Override
	public void onEnable(){
		instance = this;
		
		enableManagers();
		
		registerCommands();
	}
	
	private void enableManagers(){
		this.commandManager = new CommandManager();
		this.worldManager = new WorldManager();
	}
	
	private void registerCommands(){
		for(hubplus.command.Command command : commandManager.getCommands()){
			getCommand(command.getName().toLowerCase()).setExecutor(commandManager);
		}
	}
	
	public CommandManager getCommandManager(){
		return this.commandManager;
	}
	
	public WorldManager getWorldManager(){
		return this.worldManager;
	}

	public ChatColor getMainChatColor(){
		return this.mainColor;
	}
	
	public ChatColor getSecondaryChatColor(){
		return this.secondaryColor;
	}
	
	public static HubPlus getInstance(){
		return instance;
	}
	
}
