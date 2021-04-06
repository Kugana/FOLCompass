package FOLCompass.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CompassUtil implements Listener {

	static FOLCompass main;
	static BossBar b;
	private static Map<UUID, BossBar> bossbar = new HashMap<UUID, BossBar>();
	static double i = 0;

	public CompassUtil(FOLCompass instance) {
		main = instance;

	}

	public static HashMap<Player, KeyedBossBar> playersCompass;

	public static float calcYaw(Player player) {
		Location playerLoc = player.getLocation();
		float calcYaw = playerLoc.getYaw();
		if (calcYaw < 0.0F) {
			calcYaw += 360.0F;
		}
		return calcYaw;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (bossbar.get(player.getUniqueId()) != null) {
			if (!bossbar.get(player.getUniqueId()).getPlayers().contains(player)) {
				createCompass(player);

			}
		}
	}

	public static void createCompass(Player player) {

		b = Bukkit.createBossBar(getCompassDisplay(calcYaw(player)), BarColor.YELLOW, BarStyle.SEGMENTED_6,
				new BarFlag[0]);
		b.addPlayer(player);
		// b.setProgress(0);

		b.setTitle(getCompassDisplay(calcYaw(player)));
		b.setVisible(true);
		bossbar.put(player.getUniqueId(), b);

	}

	public static void load() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			@Override
			public void run() {

				for (Player p : Bukkit.getOnlinePlayers()) {
					if (bossbar.get(p.getUniqueId()) == null) {
						b = Bukkit.createBossBar(getCompassDisplay(calcYaw(p)), BarColor.YELLOW, BarStyle.SEGMENTED_6,
								new BarFlag[0]);
						b.addPlayer(p);
						// b.setProgress(0);

						b.setTitle(getCompassDisplay(calcYaw(p)));
						b.setVisible(true);
						bossbar.put(p.getUniqueId(), b);

					} else {

						// if (bossbar.get(p.getUniqueId()).getPlayers().contains(p)) {

						bossbar.get(p.getUniqueId()).setTitle(getCompassDisplay(calcYaw(p)));
						// }
					}
				}

			}

		}, 0L, 1 / 10L);

	}

	public static void stop() {
		// bossbar.clear();
		// if (b != null) {
		if (bossbar != null) {
			for (UUID uuid : bossbar.keySet()) {
				bossbar.get(uuid).removeAll();

			}

			// }
			// b.removeAll();
		}
	}

	public static String getCompassDisplay(float yaw) {
		yaw += 2.25F;
		if (yaw > 360.0F) {
			yaw -= 360.0F;
		}
		if ((yaw >= 180.0F) && (yaw < 184.5D)) {
			return "¡±7 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170 ";
		}
		if ((yaw >= 184.5D) && (yaw < 189.0F)) {
			return "¡±7    ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ";
		}
		if ((yaw >= 189.0F) && (yaw < 193.5D)) {
			return "¡±7    20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P ";
		}
		if ((yaw >= 193.5D) && (yaw < 198.0F)) {
			return "¡±7    ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ";
		}
		if ((yaw >= 198.0F) && (yaw < 202.5D)) {
			return "¡±7    30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P ";
		}
		if ((yaw >= 202.5D) && (yaw < 207.0F)) {
			return "¡±7    ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ";
		}
		if ((yaw >= 207.0F) && (yaw < 211.5D)) {
			return "¡±7    40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P ";
		}
		if ((yaw >= 211.5D) && (yaw < 216.0F)) {
			return "¡±7   ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ";
		}
		if ((yaw >= 216.0F) && (yaw < 220.5D)) {
			return "¡±7 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P ";
		}
		if ((yaw >= 220.5D) && (yaw < 225.0F)) {
			return "¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P  ";
		}
		if ((yaw >= 225.0F) && (yaw < 229.5D)) {
			return "¡±7 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P ";
		}
		if ((yaw >= 229.5D) && (yaw < 234.0F)) {
			return "¡±7    60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7";
		}
		if ((yaw >= 234.0F) && (yaw < 238.5D)) {
			return "¡±7    ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ";
		}
		if ((yaw >= 238.5D) && (yaw < 243.0F)) {
			return "¡±7    70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P ";
		}
		if ((yaw >= 243.0F) && (yaw < 247.5D)) {
			return "¡±7    ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ";
		}
		if ((yaw >= 247.5D) && (yaw < 252.0F)) {
			return "¡±7    80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P ";
		}
		if ((yaw >= 252.0F) && (yaw < 256.5D)) {
			return "¡±7    ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ";
		}
		if ((yaw >= 256.5D) && (yaw < 261.0F)) {
			return "¡±7    ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P ";
		}
		if ((yaw >= 261.0F) && (yaw < 265.5D)) {
			return "¡±7  ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ";
		}
		if ((yaw >= 265.5D) && (yaw < 270.0F)) {
			return "¡±7¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260  ";
		}
		if ((yaw >= 270.0F) && (yaw < 274.5D)) {
			return "¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ";
		}
		if ((yaw >= 274.5D) && (yaw < 279.0F)) {
			return "¡±7    100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ";
		}
		if ((yaw >= 279.0F) && (yaw < 283.5D)) {
			return "¡±7    110 ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P ";
		}
		if ((yaw >= 283.5D) && (yaw < 288.0F)) {
			return "¡±7    ¡P 120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ";
		}
		if ((yaw >= 288.0F) && (yaw < 292.5D)) {
			return "¡±7    120 ¡P 130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P ";
		}
		if ((yaw >= 292.5D) && (yaw < 297.0F)) {
			return "¡±7    ¡P 130¡±¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ";
		}
		if ((yaw >= 297.0F) && (yaw < 301.5D)) {
			return "¡±7    130 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P ";
		}
		if ((yaw >= 301.5D) && (yaw < 306.0F)) {
			return "¡±7   ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ";
		}
		if ((yaw >= 306.0F) && (yaw < 310.5D)) {
			return "¡±7 ¡±f NE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P ";
		}
		if ((yaw >= 310.5D) && (yaw < 315.0F)) {
			return "¡±fNE ¡±7140 ¡P 150 ¡P 160 ¡P 170  ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P  ";
		}
		if ((yaw >= 315.0F) && (yaw < 319.5D)) {
			return "¡±7 ¡P 150 ¡P 160 ¡P 170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P ";
		}
		if ((yaw >= 319.5D) && (yaw < 324.0F)) {
			return "¡±7    150 ¡P 160 ¡P 170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7";
		}
		if ((yaw >= 324.0F) && (yaw < 328.5D)) {
			return "¡±7    ¡P 160 ¡P 170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ";
		}
		if ((yaw >= 328.5D) && (yaw < 333.0F)) {
			return "¡±7    160 ¡P 170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P ";
		}
		if ((yaw >= 333.0F) && (yaw < 337.5D)) {
			return "¡±7    ¡P 170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ";
		}
		if ((yaw >= 337.5D) && (yaw < 342.0F)) {
			return "¡±7    170 ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P ";
		}
		if ((yaw >= 342.0F) && (yaw < 346.5D)) {
			return "¡±7    ¡P ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ";
		}
		if ((yaw >= 346.5D) && (yaw < 351.0F)) {
			return "¡±7   ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P ";
		}
		if ((yaw >= 351.0F) && (yaw < 355.5D)) {
			return "¡±7 ¡±f E ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ";
		}
		if ((yaw >= 355.5D) && (yaw < 360.0F)) {
			return "¡±fE ¡±7 ¡P 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350  ";
		}
		if ((yaw >= 0.0F) && (yaw < 4.5D)) {
			return "¡±7 190 ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ";
		}
		if ((yaw >= 4.5D) && (yaw < 9.0F)) {
			return "¡±7    ¡P 200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ";
		}
		if ((yaw >= 9.0F) && (yaw < 13.5D)) {
			return "¡±7    200 ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P ";
		}
		if ((yaw >= 13.5D) && (yaw < 18.0F)) {
			return "¡±7    ¡P 210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ";
		}
		if ((yaw >= 18.0F) && (yaw < 22.5D)) {
			return "¡±7    210 ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P ";
		}
		if ((yaw >= 22.5D) && (yaw < 27.0F)) {
			return "¡±7    ¡P 220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ";
		}
		if ((yaw >= 27.0F) && (yaw < 31.5D)) {
			return "¡±7    220 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P ";
		}
		if ((yaw >= 31.5D) && (yaw < 36.0F)) {
			return "¡±7   ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ";
		}
		if ((yaw >= 36.0F) && (yaw < 40.5D)) {
			return "¡±7 ¡±f SE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P ";
		}
		if ((yaw >= 40.5D) && (yaw < 45.0F)) {
			return "¡±fSE ¡±7 230 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P  ";
		}
		if ((yaw >= 45.0F) && (yaw < 49.5D)) {
			return "¡±7 ¡P 240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P ";
		}
		if ((yaw >= 49.5D) && (yaw < 54.0F)) {
			return "¡±7    240 ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7";
		}
		if ((yaw >= 54.0F) && (yaw < 58.5D)) {
			return "¡±7    ¡P 250 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ";
		}
		if ((yaw >= 58.5D) && (yaw < 63.0F)) {
			return "¡±7    240 ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P ";
		}
		if ((yaw >= 63.0F) && (yaw < 67.5D)) {
			return "¡±7    ¡P 260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ";
		}
		if ((yaw >= 67.5D) && (yaw < 72.0F)) {
			return "¡±7    260 ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P ";
		}
		if ((yaw >= 72.0F) && (yaw < 76.5D)) {
			return "¡±7    ¡P ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ";
		}
		if ((yaw >= 76.5D) && (yaw < 81.0F)) {
			return "¡±7    ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P ";
		}
		if ((yaw >= 81.0F) && (yaw < 85.5D)) {
			return "¡±7  ¡±f S ¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ";
		}
		if ((yaw >= 85.5D) && (yaw < 90.0F)) {
			return "¡±7S  ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80  ";
		}
		if ((yaw >= 90.0F) && (yaw < 94.5D)) {
			return "¡±7 ¡P 280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ";
		}
		if ((yaw >= 94.5D) && (yaw < 99.0F)) {
			return "¡±7    280 ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ";
		}
		if ((yaw >= 99.0F) && (yaw < 103.5D)) {
			return "¡±7    ¡P 290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P ";
		}
		if ((yaw >= 103.5D) && (yaw < 108.0F)) {
			return "¡±7    290 ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ";
		}
		if ((yaw >= 108.0F) && (yaw < 112.5D)) {
			return "¡±7    ¡P 300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P ";
		}
		if ((yaw >= 112.5D) && (yaw < 117.0F)) {
			return "¡±7    300 ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ";
		}
		if ((yaw >= 117.0F) && (yaw < 121.5D)) {
			return "¡±7    ¡P 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P ";
		}
		if ((yaw >= 121.5D) && (yaw < 126.0F)) {
			return "¡±7   310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ";
		}
		if ((yaw >= 126.0F) && (yaw < 130.5D)) {
			return "¡±7 310 ¡±f SW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P ";
		}
		if ((yaw >= 130.5D) && (yaw < 135.0F)) {
			return "¡±fSW ¡±7 320 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P  ";
		}
		if ((yaw >= 135.0F) && (yaw < 139.5D)) {
			return "¡±7 ¡P 330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130";
		}
		if ((yaw >= 139.5D) && (yaw < 144.0F)) {
			return "¡±7    330 ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7";
		}
		if ((yaw >= 144.0F) && (yaw < 148.5D)) {
			return "¡±7    ¡P 340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ";
		}
		if ((yaw >= 148.5D) && (yaw < 153.0F)) {
			return "¡±7    340 ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P ";
		}
		if ((yaw >= 153.0F) && (yaw < 157.5D)) {
			return "¡±7    ¡P 350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ";
		}
		if ((yaw >= 157.5D) && (yaw < 162.0F)) {
			return "¡±7    350 ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ¡P ";
		}
		if ((yaw >= 162.0F) && (yaw < 166.5D)) {
			return "¡±7    ¡P ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ¡P 160 ";
		}
		if ((yaw >= 166.5D) && (yaw < 171.0F)) {
			return "¡±7    ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ¡P 160 ¡P ";
		}
		if ((yaw >= 171.0F) && (yaw < 175.5D)) {
			return "¡±7  ¡±f W ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ¡P 160 ¡P 170 ";
		}
		if ((yaw >= 175.5D) && (yaw < 180.0F)) {
			return "¡±fW ¡±7 ¡P 10 ¡P 20 ¡P 30 ¡P 40 ¡±f NW ¡±7 50 ¡P 60 ¡P 70 ¡P 80 ¡P ¡±c N ¡±7 ¡P 100 ¡P 110 ¡P 120 ¡P 130 ¡±f NE ¡±7 140 ¡P 150 ¡P 160 ¡P 170 ¡P";
		}
		return "¡±8Compass Error";
	}

}
