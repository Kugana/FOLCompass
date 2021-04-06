package FOLCompass.Versions;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R2.PacketPlayOutChat;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle.EnumTitleAction;

public class Version_v1_9_R2 implements NMS {
	
	@Override
	public void sendTitle(Player p, String titleMessage, int fadIn, int onScreen, int fedeOut) {
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\": \"" + titleMessage + "\"}"), fadIn, onScreen, fedeOut);

		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);

	}

	@Override
	public void sendActionbar(Player p, String message) {
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\": \"" + message + "\"}"), (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

	}

}
