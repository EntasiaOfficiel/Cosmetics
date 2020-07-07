package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.apis.nbt.EntityNBT;
import fr.entasia.apis.nbt.NBTComponent;
import fr.entasia.apis.utils.ItemUtils;
import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.CosmeticPlayer;
import fr.entasia.cosmetiques.utils.Utils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import fr.entasia.cosmetiques.utils.pets.as.ASFrame;
import fr.entasia.cosmetiques.utils.pets.as.ASStruc;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PetsUtils {

	public static double angle(double a){
		if(a>0)return a;
		else return 180+a+180;
	}

	public static ItemStack getSkull(ItemStack item, String uuidstr, String texture){
		SkullMeta smeta = (SkullMeta)item.getItemMeta();
		ItemUtils.setTexture(smeta, ItemUtils.genProfile(uuidstr, texture));
		item.setItemMeta(smeta);
		return item;

	}

	public static void spawnPet(Player p, Pets pet){

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


		CurrentPet cp = new CurrentPet(pet);
		cp.origin = (Chicken) p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
		cp.origin.setCustomNameVisible(false);

		cp.origin.setBaby();
		cp.origin.setAgeLock(true);
		cp.origin.setSilent(true);
		cp.origin.setInvulnerable(true);
		cp.origin.setRemoveWhenFarAway(false);
		cp.origin.setCollidable(false);

		EntityNBT.addNBT(cp.origin, new NBTComponent("{Invisible:1}"));
		cp.origin.setMetadata("Pet", new FixedMetadataValue(Main.main,"Origin"));
		cp.origin.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 255, false,false));

		Main.multiversion.setPathGoal(cp.origin, p);


		ASData asd;
		for(ASStruc i : pet.data){
			asd = new ASData(i);
			asd.ent = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);

			asd.ent.setGravity(false);
			asd.ent.setCustomNameVisible(false);
			asd.ent.setInvulnerable(true);
			asd.ent.setRemoveWhenFarAway(false);
			asd.ent.setArms(true);
			asd.ent.setCollidable(false);
			asd.ent.setSilent(true);
			asd.ent.setMarker(false);

			asd.ent.setSmall(asd.struct.small);

			PetsUtils.updateAS(asd, asd.struct.frames.get(0));

			EntityNBT.addNBT(asd.ent, new NBTComponent("{Invisible:1}"));
			asd.ent.setMetadata("Pet", new FixedMetadataValue(Main.main,"Creator"));

			cp.armor_stands.add(asd);
		}
		CosmeticPlayer.getCosPlay(p).pet = cp;
	}

	public static void removePet(CosmeticPlayer cp){
		CurrentPet pet = cp.pet;
		cp.pet = null;
		pet.origin.remove();

		for (ASData asd : pet.armor_stands) {
			asd.ent.remove();
		}
	}

	public static Vector rotate(Vector vector, double degres) {
		double angle= Math.toRadians(degres);
		double x = (vector.getX() * Math.cos(angle) - vector.getZ() * Math.sin(angle));
		double z = (vector.getX() * Math.sin(angle) + vector.getZ() * Math.cos(angle));
		return new Vector(x,vector.getY(),z);
	}

	public static void updateAS(ASData asd, ASFrame frame){
		if(frame.head!=null)asd.ent.setHelmet(frame.head);
		if(frame.headpos!=null)asd.ent.setHeadPose(frame.headpos);

		if(frame.rightarm!=null)asd.ent.setItemInHand(frame.rightarm);
		if(frame.rightarmpos!=null)asd.ent.setRightArmPose(frame.rightarmpos);

		if(frame.leftarm!=null)asd.ent.getEquipment().setItemInOffHand(frame.leftarm);
		if(frame.leftarmpos!=null)asd.ent.setLeftArmPose(frame.leftarmpos);
	}
}
