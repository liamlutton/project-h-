package hubplus.command.commands;

import hubplus.command.Command;
import hubplus.core.HubPlus;

import org.bukkit.entity.Player;

public class HelpCommand extends Command {

	public HelpCommand(String name, String description) {
		super(name, description);
	}

	@Override
	public void run(Player sender) {
		for(Command command : HubPlus.getInstance().getCommandManager().getCommands()){
			if(sender.hasPermission(command.getPermission())){
				
			}
		}
	}

}
