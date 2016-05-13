package src.com.walrusone.skywars.commands;

import org.bukkit.ChatColor;
import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.GamePlayer;
import src.com.walrusone.skywars.menus.BuyColorMenu;
import src.com.walrusone.skywars.utilities.Messaging;


public class GlassShopCmd extends BaseCmd { 

	public GlassShopCmd() {
		forcePlayer = true;
		cmdName = "glassshop";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Menu for purchasing glass colors.";

	}

	@Override
	public boolean run() {
		if (SkyWarsReloaded.getCfg().purchaseColorClassEnabled()) {
			GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
			if (!gPlayer.inGame()) {
					new BuyColorMenu(gPlayer);
					return true;
			} else {
				sender.sendMessage(new Messaging.MessageFormatter().format("error.shop-not-available"));
				return true;
			}
			
		} else {
			sender.sendMessage(ChatColor.RED + "Glass Shop is disabled!");
			return true;
		}
	}
}
