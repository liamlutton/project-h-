package hubplus.worlds;

import hubplus.core.Manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;

public class WorldManager implements Manager {

	private List<String> hubWorlds = new ArrayList<>();
	
	public WorldManager(){
		
	}
	
	public List<String> getHubWorlds(){
		return this.hubWorlds;
	}
	
	public boolean isHub(World world){
		return isHub(world.getName());
	}
	
	public boolean isHub(String worldName){
		for(String name : hubWorlds){
			if(name.equalsIgnoreCase(worldName)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void disable() {
		hubWorlds.clear();
		System.out.println("WorldManager disabled.");
	}

}
