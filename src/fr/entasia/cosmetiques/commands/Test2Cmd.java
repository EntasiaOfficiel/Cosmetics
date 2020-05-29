package fr.entasia.cosmetiques.commands;

import fr.entasia.cosmetiques.utils.InvsManager;
import fr.entasia.cosmetiques.utils.particles.Particles;
import fr.entasia.cosmetiques.utils.pets.Pets;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
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

		for(Location loce : Particles.getCirclePoints(8,2.5,p.getLocation().add(0,1,0))){
				Location loc = loce.add(-p.getLocation().getX(),-p.getLocation().getY(),-p.getLocation().getZ());
				Bukkit.broadcastMessage(loc.getX()+";"+loc.getZ());
		}

		return false;
	}

}
