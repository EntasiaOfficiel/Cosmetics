package fr.entasia.cosmetiques.commands;

import fr.entasia.cosmetiques.utils.InvsManager;
import fr.entasia.cosmetiques.utils.pets.Pets;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test2Cmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if(args.length ==0){
			InvsManager.cosmMenuOpen((Player)sender);
			return false;
		}

		Player p = (Player) sender;
		Pets a = Pets.valueOf(args[0]);
		PetsUtils.spawnPet(p, a);

		return false;
	}

}
