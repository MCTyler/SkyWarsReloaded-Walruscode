package src.com.walrusone.skywars.commands;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.Game;
import src.com.walrusone.skywars.game.GamePlayer;
import src.com.walrusone.skywars.game.Game.GameState;
import src.com.walrusone.skywars.utilities.Messaging;

public class StartCmd extends BaseCmd { 
	
	public StartCmd() {
		forcePlayer = true;
		cmdName = "start";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: Force start a game";

	}

	@Override
	public boolean run() {
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayer(player.getUniqueId());
		if (gPlayer.inGame()) {
			Game game = gPlayer.getGame();
			if (game.getState() == GameState.PREGAME) {
				game.startGame();
			}
			return true;
		} else {
			sender.sendMessage(new Messaging.MessageFormatter().format("error.not-in-game"));
			return true;
		}
	}

}
