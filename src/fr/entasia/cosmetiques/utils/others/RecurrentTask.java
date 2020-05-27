package fr.entasia.cosmetiques.utils.others;

import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.CosmeticPlayer;
import fr.entasia.cosmetiques.utils.Utils;
import fr.entasia.cosmetiques.utils.particles.ParticleStruct;
import fr.entasia.cosmetiques.utils.particles.Particles;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import fr.entasia.cosmetiques.utils.pets.as.ASFrame;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class RecurrentTask extends BukkitRunnable {

	public static double angle(double a){
		if(a>0)return a;
		else return 180+a+180;
	}

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
		for (Particles p : Particles.values()) {
			if(p.structs==null)continue;
			for (ParticleStruct ps : p.structs) {
				if(ps.framerate>1){
					ps.framecounter++;
					if(ps.framecounter==ps.framerate)ps.framecounter=0;
				}
			}
		}

		for (CosmeticPlayer cp: Utils.playerCache.values()) {
			if(cp.hasPet()) {
				//déplacer le pet
				CurrentPet pet = cp.pet;
				Player p = cp.p;

				if (!p.getWorld().getName().equalsIgnoreCase(pet.origin.getWorld().getName())) {
					pet.origin.teleport(p.getLocation());
				}else if(pet.origin.getLocation().distance(p.getLocation()) > 20 && !p.isFlying() && !p.isGliding() && !isTooHigh(p)){
					pet.origin.teleport(p.getLocation());
				}

				float oyaw = pet.origin.getLocation().getYaw();


				double x,z;
				for(ASData asd : pet.armor_stands){
					ASFrame frame;

					// ANIMATION - 1 : Frame checking
					if(asd.struct.framerate!=0){
						int frameID = asd.getCurrentFrameID();

						if(frameID==0&&pet.type.moveOnly){
							if(pet.origin.getLocation().equals(pet.lastloc))continue;
							pet.lastloc = pet.origin.getLocation();
						}

						asd.addTickN();

						frame = asd.struct.frames.get(frameID);

						PetsUtils.updateAS(asd, frame); // ANIMATION - 2


					}else frame = asd.struct.frames.get(0);


					// ROTATION - 1
					double anglePoulet = angle(oyaw);
					Vector vector;

					// ROTATION - 2 : Si la frame ne contient pas de position on se base sur la position de la dernière frame, enregistrée dans asd.lastrloc
					if(frame.rloc==null){
						if(asd.lastrloc==null){
							Main.main.getLogger().severe("Pet non valide : "+pet.type.name()+" : Pas de location pour la première frame !");
							continue;
						}else vector = PetsUtils.rotate(asd.lastrloc, anglePoulet);
					}else{
						vector = PetsUtils.rotate(frame.rloc, anglePoulet);
						asd.lastrloc = frame.rloc;
					}

					Location a = pet.origin.getLocation().add(vector);
					a.setYaw(a.getYaw()+frame.locrotation);
					asd.ent.teleport(a);
				}
			}


			if(cp.hasParticle()){
				cp.particle.update(cp.p.getLocation());
				//afficher la particule
			}
		}
	}
}
