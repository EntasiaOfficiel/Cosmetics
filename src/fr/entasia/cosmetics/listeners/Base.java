package fr.entasia.cosmetics.listeners;

import fr.entasia.cosmetics.utils.CosmeticPlayer;
import fr.entasia.cosmetics.utils.CosmAPI;
import fr.entasia.cosmetics.utils.pets.CurrentPet;
import fr.entasia.cosmetics.utils.pets.Pet;
import fr.entasia.cosmetics.utils.pets.PetsUtils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class Base implements Listener {



	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(CosmAPI.playerCache.containsKey(p.getUniqueId())){
			if(CosmAPI.playerCache.get(p.getUniqueId()) != null){
				CosmeticPlayer cosp = CosmAPI.playerCache.get(p.getUniqueId());
				if(cosp.hasPet()){
					PetsUtils.removePet(cosp);
				}
			}
		}

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		CosmeticPlayer cp = CosmAPI.playerCache.get(p.getUniqueId());
		if(cp !=null){
            cp.p = p;
			if (cp.hasPet()) {
				CurrentPet pet = cp.pet;
				Pet pets = pet.type;
				PetsUtils.spawnPet(p,pets);
				p.sendMessage("§7Ton dernier pet a été respawn automatiquement");
			}
	    }
	}



	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		CosmeticPlayer cp = CosmAPI.playerCache.get(p.getUniqueId());
		if(cp!=null){
			if(cp.hasPet()){

				PetsUtils.removePet(cp);
			}
			if(cp.hasParticle()){
				cp.particle = null;
			}
		}
	}



	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		CosmeticPlayer cp = CosmAPI.playerCache.get(p.getUniqueId());
		if (cp != null){
			cp.p = p;
			if (cp.hasPet()) {
				CurrentPet pet = cp.pet;
				Pet pets = pet.type;
				PetsUtils.spawnPet(p, pets);
				p.sendMessage("§7Ton dernier pet a été respawn automatiquement");
			}
		}
	}


	@EventHandler
	public void onPetHurtPet(EntityDamageByEntityEvent e){
		if(e.getEntity().hasMetadata("Pet")) e.setCancelled(true);
		else if(e.getDamager().hasMetadata("Pet")) e.setCancelled(true);
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