package src.com.walrusone.skywars.commands;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.GamePlayer;
import src.com.walrusone.skywars.menus.SpecGameMenu;
import src.com.walrusone.skywars.utilities.Messaging;

public class SpectateCmd extends BaseCmd { 
	
	public SpectateCmd() {
		forcePlayer = true;
		cmdName = "spectate";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Allows a user to spectate games";

	}

	@Override
	public boolean run() {
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		if (!gPlayer.inGame()) {
			new SpecGameMenu(gPlayer);
			return true;
		} else {
			sender.sendMessage(new Messaging.MessageFormatter().format("error.no-spectate-other-worlds"));
			return true;
		}
	}

}
