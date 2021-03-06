package src.com.walrusone.skywars.commands;

import org.bukkit.ChatColor;

import src.com.walrusone.skywars.SkyWarsReloaded;
import src.com.walrusone.skywars.game.GamePlayer;
import src.com.walrusone.skywars.utilities.Util;


public class AddPointsCmd extends BaseCmd { 
	
	public AddPointsCmd() {
		forcePlayer = false;
		cmdName = "addpoints";
		argLength = 3; //counting cmdName
		usage = "<player> <points>";
		desc = ":: Adds <points> to the players balance";

	}

	@Override
	public boolean run() {
		String playerName = args[1];
		int points = 0;
		if (Util.isInteger(args[2])) {
			points = Integer.valueOf(args[2]);
		}
		if (points <= 0) {
			sender.sendMessage(ChatColor.RED + "<points> must be a integer greater than 0");
			return true;
		}
		
		GamePlayer gPlayer = SkyWarsReloaded.getPC().getPlayerByName(playerName);
		if (gPlayer != null) {
			gPlayer.setBalance(gPlayer.getBalance() + points);
			sender.sendMessage(ChatColor.GREEN + "" + points +" were added to " + playerName + "'s balance");
			if (!gPlayer.inGame()) {
				SkyWarsReloaded.getScore().getScoreboard(gPlayer.getP());
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Could not find a player named: " + playerName);
		}
		return true;
	}

}
