package src.com.walrusone.skywars.commands;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.Game;


public class GamesCmd extends BaseCmd { 

	public GamesCmd() {
		forcePlayer = false;
		cmdName = "games";
		argLength = 1; //counting cmdName
		usage = "";
		desc = ":: List all games currenlty in progress";

	}

	@Override
	public boolean run() {
		for (Game game: SkyWarsReloaded.getGC().getGames()) {
			int number = game.getGameNumber();
			String map = game.getMapName();
			int players = game.getPlayers().size();
			String message = number + "   " + map + "   " + players;
			sender.sendMessage(message);
		}
		return true;
	}
}
