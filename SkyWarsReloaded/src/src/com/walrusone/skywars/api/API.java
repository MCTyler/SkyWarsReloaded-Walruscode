package src.com.walrusone.skywars.api;

import java.util.UUID;

import org.bukkit.entity.Player;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.GamePlayer;

public class API {
	
	public static int getPoints(Player player) {
		GamePlayer gplayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		return gplayer.getBalance();
	}
	
	public static int getPoints(UUID id) {
		GamePlayer gplayer = SkyWarsReloaded.getPC().getPlayer(id);
		return gplayer.getBalance();
	}
}
