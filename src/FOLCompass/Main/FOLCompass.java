package FOLCompass.Main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;



public class FOLCompass extends JavaPlugin {
	
	static FOLCompass plugin;

	@Override
	public void onEnable() {
		onEvent();
		CompassUtil.load();
	}

	@Override
	public void onDisable() {
		CompassUtil.stop();
	}
	
	public void onEvent() {
		getServer().getPluginManager().registerEvents(new CompassUtil(this), this);
		
	}

	public Plugin getInstance() {
		return plugin;

	}

}
