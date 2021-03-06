package fr.entasia.cosmetics.utils.others;

import fr.entasia.cosmetics.Main;
import fr.entasia.cosmetics.utils.CosmeticPlayer;
import fr.entasia.cosmetics.utils.CosmAPI;
import fr.entasia.cosmetics.utils.particles.Particle;
import fr.entasia.cosmetics.utils.particles.ParticleStruct;
import fr.entasia.cosmetics.utils.pets.CurrentPet;
import fr.entasia.cosmetics.utils.pets.as.ASData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RecurrentTask extends BukkitRunnable {


	public static boolean isTooHigh(Player p){
		Location loc = p.getLocation().clone();
		int high = 0;
		while(loc.getBlockY()>0){
			loc.setY(loc.getY()-1);
			if(loc.getBlock().getType()== Material.AIR)high++;
			else break;
		}
		return high > 3;
	}

	@Override
	public void run() {
		for (Particle p : CosmAPI.particleList) {
			if(p.structs==null)continue;
			for (ParticleStruct ps : p.structs) {
				if(ps.framerate>1){
					ps.framecounter++;
					if(ps.framecounter==ps.framerate)ps.framecounter=0;
				}
			}
		}

		for (CosmeticPlayer cp: CosmAPI.playerCache.values()) {
			if(cp.hasPet()) {
				//déplacer le pet
				CurrentPet pet = cp.pet;
				Player p = cp.p;

				if (!p.getWorld().getName().equalsIgnoreCase(pet.origin.getWorld().getName())) {
					new BukkitRunnable(){
						@Override
						public void run() {
							pet.origin.teleport(p.getLocation());
							Main.multiversion.setPathGoal(pet.origin, p);
							cancel();
						}
					}.runTask(Main.main);


				}else if(pet.origin.getLocation().distance(p.getLocation()) > 20 && !p.isFlying() && !p.isGliding() && !isTooHigh(p)){
					pet.origin.teleport(p.getLocation());
				}


				for(ASData asd : pet.armor_stands){
					asd.struct.update(pet,asd,p);
				}
			}


			if(cp.hasParticle()){
				cp.particle.update(cp.p.getLocation());
			}
		}
	}
}
