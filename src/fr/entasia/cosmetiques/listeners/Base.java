package fr.entasia.cosmetiques.listeners;

import fr.entasia.apis.other.InstantFirework;
import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.CosmeticPlayer;
import fr.entasia.cosmetiques.utils.Utils;
import fr.entasia.cosmetiques.utils.particles.Particles;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.Pets;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Base implements Listener {



	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(Utils.playerCache.containsKey(p.getUniqueId())){
			if(Utils.playerCache.get(p.getUniqueId()) != null){
				CosmeticPlayer cosp = Utils.playerCache.get(p.getUniqueId());
				if(cosp.hasPet()){
					CurrentPet pete = cosp.pet;
					pete.origin.remove();
					for(ASData asd : pete.armor_stands){
						asd.ent.remove();
					}
				}
			}
		}

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		CosmeticPlayer cp = Utils.playerCache.get(p.getUniqueId());
		if(cp !=null){
            cp.p = p;
			if (cp.hasPet()) {
				CurrentPet pet = cp.pet;
				Pets pets = pet.type;
				PetsUtils.spawnPet(p,pets);
				p.sendMessage("§7Votre dernier pet a été respawn automatiquement");
			}
	    }
	}



	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		CosmeticPlayer cp = Utils.playerCache.get(p.getUniqueId());
		if(cp!=null){
			if(cp.hasPet()){

				CurrentPet cPet = cp.pet;
				cp.pet = null;
				cPet.origin.remove();
				for(ASData asd : cPet.armor_stands){
					asd.ent.remove();
				}
			}
			if(cp.hasParticle()){
				cp.particle = null;
			}
		}
	}



	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		CosmeticPlayer cp = Utils.playerCache.get(p.getUniqueId());
		if (cp != null){
			cp.p = p;
			if (cp.hasPet()) {
				CurrentPet pet = cp.pet;
				Pets pets = pet.type;
				PetsUtils.spawnPet(p, pets);
				p.sendMessage("§7Votre dernier pet a été respawn automatiquement");
			}
		}
	}


	@EventHandler
	public void onPetHurtPet(EntityDamageByEntityEvent e){
		if(e.getEntity().hasMetadata("Pet")) e.setCancelled(true);
		if(e.getDamager().hasMetadata("Pet")) e.setCancelled(true);
	}

	@EventHandler
	public void onPetChange(PlayerArmorStandManipulateEvent e){
		List<MetadataValue> a = e.getRightClicked().getMetadata("Pet");
		if(a.size()!=0&&a.get(0).asString().equals("Creator")){
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPetDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof LivingEntity){
			LivingEntity ent = (LivingEntity)e.getEntity();
			if(ent.hasMetadata("Pet")) {
				e.setCancelled(true);
				ent.setFireTicks(0);
			}
		}
	}

}