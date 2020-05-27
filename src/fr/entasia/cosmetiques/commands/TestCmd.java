package fr.entasia.cosmetiques.commands;

import fr.entasia.cosmetiques.utils.CosmeticPlayer;
import fr.entasia.cosmetiques.utils.particles.Particles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		Player p = (Player) sender;
		CosmeticPlayer.getCosPlay(p).particle = Particles.valueOf(args[0]);
		return false;
	}

}
