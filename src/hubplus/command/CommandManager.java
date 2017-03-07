package hubplus.command;

import hubplus.core.HubPlus;
import hubplus.core.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements Manager, CommandExecutor {

	private List<hubplus.command.Command> commands = new ArrayList<>();
	
	public CommandManager(){
		
	}
	
	public boolean isCommand(String name){
		for(hubplus.command.Command command : this.commands){
			if(command.getName().equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}
	
	public hubplus.command.Command getCommand(String name){
		for(hubplus.command.Command command : this.commands){
			if(command.getName().equalsIgnoreCase(name)){
				return command;
			}
		}
		return null;
	}
	
	public List<hubplus.command.Command> getCommands(){
		return this.commands;
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		if(isCommand(arg1.getName())){
			hubplus.command.Command command = getCommand(arg1.getName());
			if(arg0 instanceof Player){
				Player player = (Player) arg0;
				if(HubPlus.getInstance().getWorldManager().isHub(player.getWorld())){
					command.run(player);
				}
			}else{
				arg0.sendMessage("This Hub+ command is only accessable by players.");
			}
		}
		
		return false;
	}

	@Override
	public void disable() {
		this.commands.clear();
		System.out.println("CommandManager disabled.");
	}
 
}
