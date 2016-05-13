package src.com.walrusone.skywars.runnables;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.Game;

public class CheckForMinPlayers implements Runnable {

	@Override
	public void run() {
		for(Game game: SkyWarsReloaded.getGC().getGames()) {
    		game.prepareForStart();
    	}
	}

}
