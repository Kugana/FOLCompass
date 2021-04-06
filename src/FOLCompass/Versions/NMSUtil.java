package FOLCompass.Versions;

import org.bukkit.Bukkit;

import FOLCompass.Main.FOLCompass;
import net.md_5.bungee.api.ChatColor;

public class NMSUtil {


	static NMS nms;

	static FOLCompass FOLBuild;

	public static String version = null;

	public NMSUtil(FOLCompass instance) {

		FOLBuild = instance;

	}

	public static void setupNMS() {

		try {
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		} catch (ArrayIndexOutOfBoundsException e) {
			Bukkit.getConsoleSender().sendMessage("[" + FOLBuild.getInstance().getDescription().getName() + "]"
					+ ChatColor.RED + "Something went wrong wile loading versions!!");
			Bukkit.getScheduler().cancelAllTasks();
			Bukkit.getPluginManager().disablePlugin(FOLBuild.getInstance());
		}
		if (version.equals("v1_8_R1")) {
			nms = new Version_v1_8_R1();
		} else if (version.equals("v1_8_R2")) {
			nms = new Version_v1_8_R2();
		} else if (version.equals("v1_8_R3")) {
			nms = new Version_v1_8_R3();
		} else if (version.equals("v1_9_R1")) {
			nms = new Version_v1_9_R1();
		} else if (version.equals("v1_9_R2")) {
			nms = new Version_v1_9_R2();
		} else if (version.equals("v1_10_R1")) {
			nms = new Version_v1_10_R1();
		} else if (version.equals("v1_11_R1")) {
			nms = new Version_v1_11_R1();
		} else if (version.equals("v1_12_R1")) {
			nms = new Version_v1_12_R1();
		}else if (version.equals("v1_13_R1")) {
			nms = new Version_v1_13_R1();
		}else if (version.equals("v1_13_R2")) {
			nms = new Version_v1_13_R2();
		}else if (version.equals("v1_14_R1")) {
			nms = new Version_v1_1_14_R1();

		} else {
			Bukkit.getConsoleSender().sendMessage("[" + FOLBuild.getInstance().getDescription().getName() + "]"
					+ ChatColor.RED + "You current versions," + version + ", is no supported!");
			Bukkit.getScheduler().cancelAllTasks();
			Bukkit.getPluginManager().disablePlugin(FOLBuild.getInstance());
		}

	}

	public static NMS getNMS() {
		return nms;
	}

}
