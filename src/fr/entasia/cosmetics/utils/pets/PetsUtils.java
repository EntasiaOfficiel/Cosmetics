package fr.entasia.cosmetics.utils.pets;

import fr.entasia.apis.nbt.EntityNBT;
import fr.entasia.apis.nbt.NBTComponent;
import fr.entasia.apis.utils.ItemUtils;
import fr.entasia.cosmetics.Main;
import fr.entasia.cosmetics.utils.CosmeticPlayer;
import fr.entasia.cosmetics.utils.CosmAPI;
import fr.entasia.cosmetics.utils.pets.as.ASData;
import fr.entasia.cosmetics.utils.pets.as.ASFrame;
import fr.entasia.cosmetics.utils.pets.as.ASStruc;
import org.bukkit.Material;
import org.bukkit.Particle;
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

	public static void registerAllPet(){
		CosmAPI.registerPet(new Pet(1, "pet:dog", "66381e813ef32aaaabcfe2a84f913a65691bb32b7d82dc2222dd58a5534c", "§7Chien","§7Le meilleur amis de l'homme, aussi sur Entasia",  1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:dog", "66381e813ef32aaaabcfe2a84f913a65691bb32b7d82dc2222dd58a5534c").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(2, "pet:bee", "9394d758e04b4323e6e7ef3489fe4d0078c2efba8851c03a7deb6d4182c7ea3a", "§7Abeille Robot","§7Une abeille terminator... Maintenant vous saurez qu'il faut se méfier",  1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -0.3, 0).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:bee", "9394d758e04b4323e6e7ef3489fe4d0078c2efba8851c03a7deb6d4182c7ea3a").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(3, "pet:aries", "ec7864b99c63edc4d0d34a8eb6591742a8db6dafabe12b168554a368f97687cb", "§7Bélier","§7Si c'est pas mignon ça ",  1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:aries", "ec7864b99c63edc4d0d34a8eb6591742a8db6dafabe12b168554a368f97687cb").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(4, "pet:earth", "2e2cc42015e6678f8fd49ccc01fbf787f1ba2c32bcf559a015332fc5db50", "§7Terre","§7Alors là, c'est le pied , la Terre te suis , c'est fou",  1000,false,false,true,
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setLocation(0, -0.3, 0).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:earth", "2e2cc42015e6678f8fd49ccc01fbf787f1ba2c32bcf559a015332fc5db50").setHeadPos(0, 0, 0),
						new ASFrame().setHeadPos(0, 22.5, 0),
						new ASFrame().setHeadPos(0, 45, 0),
						new ASFrame().setHeadPos(0, 67.5, 0)
				)));
		CosmAPI.registerPet(new Pet(5, "pet:panda_menu", "d8cdd4f285632c25d762ece25f4193b966c2641b15d9bdbc0a113023de76ab", "§7Panda","§7Roule, roule petit panda",  1000,false,true,true,
				new ASStruc().setFrameRate(3).setFrames(
						new ASFrame().setLocation(0, -1.1, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:panda", "10f982d56a173a4392a9b791cb29b88f1cde6f7b25e2f5dc5325706257da3e3a").setHeadPos(0, 0, 90),
						new ASFrame().setHeadPos(0, 337.5, 90),
						new ASFrame().setHeadPos(0, 315, 90),
						new ASFrame().setHeadPos(0, 292.5, 90),
						new ASFrame().setHeadPos(0, 270, 90),
						new ASFrame().setHeadPos(0, 247.5, 90),
						new ASFrame().setHeadPos(0, 225, 90),
						new ASFrame().setHeadPos(0, 202.5, 90),
						new ASFrame().setHeadPos(0, 180, 90),
						new ASFrame().setHeadPos(0, 157.5, 90),
						new ASFrame().setHeadPos(0, 135, 90),
						new ASFrame().setHeadPos(0, 112.5, 90),
						new ASFrame().setHeadPos(0, 90, 90),
						new ASFrame().setHeadPos(0, 67.5, 90),
						new ASFrame().setHeadPos(0, 45, 90),
						new ASFrame().setHeadPos(0, 22.5, 90)
				)));
		CosmAPI.registerPet(new Pet(6, "pet:cochon_mc", "369551dcc663c5db7c099ff9640b73e26d8f7c63ad5676b41d2614c2d380ce15", "§7Cochon dans un wagon","§7Oh tien , un Poporc sauvage !", 1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:cochon_minecart","369551dcc663c5db7c099ff9640b73e26d8f7c63ad5676b41d2614c2d380ce15").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(7, "pet:renard","fbdffe9642fc5280e68ce488e3bcf440687ed3bc566e315af824f428b6ff715", "§7Renard","§7Rox et Rouky , amis pour la vie",  1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:renard","fbdffe9642fc5280e68ce488e3bcf440687ed3bc566e315af824f428b6ff715").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(8, "pet:lapin","17ab6eb88246489f4245e15e2035f23476d058e1ea308276387316aabcc52ed", "§7Lapin","§7Malheuresement ça ne vous aidera pas à sauter plus haut",  1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:lapin","17ab6eb88246489f4245e15e2035f23476d058e1ea308276387316aabcc52ed").setHeadPos(0, 0, 0)
				)));
		CosmAPI.registerPet(new Pet(9, "pet:slime","5accc1b1d40d70d8bf6f2136b86edd9d1595e3a07fa2ea97b73f9bc5e90ae3b5", "§7Slime multicolore","§7J'aime les slimes , pas vous ?", 1000,false,false,true,
				new ASStruc().setFrameRate(0).setFrames(
						new ASFrame().setLocation(0, -1.4, 0).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3),
								"pet:slime","5accc1b1d40d70d8bf6f2136b86edd9d1595e3a07fa2ea97b73f9bc5e90ae3b5").setHeadPos(0, 0, 0),
						new ASFrame().setLocation(0, -1, 0),
						new ASFrame().setLocation(0, -0.6, 0),
						new ASFrame().setLocation(0, -0.2, 0),
						new ASFrame().setLocation(0, -0.1, 0),
						new ASFrame().setLocation(0, -0.2, 0),
						new ASFrame().setLocation(0, -0.6, 0),
						new ASFrame().setLocation(0, -1, 0)
				)));
		CosmAPI.registerPet(new Pet(10, "pet:pinguin", "d3c57facbb3a4db7fd55b5c0dc7d19c19cb0813c748ccc9710c714727551f5b9", "§7Pinguin","§7Qui n'a jamais rêvé d'avoir un petit pinguin qui se dandine ?", 1000,false,true,true,
				new ASStruc().setFrameRate(6).setSmall().setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(0, -0.4, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:pinguin_body", "acea5e6a750c3ce1aa6c1419781f4f6971905d056e46cbe8797e70a528c0e08d"),
						new ASFrame().setHeadPos(0, 0, 5),
						new ASFrame().setHeadPos(0, 0, 0),
						new ASFrame().setHeadPos(0, 0, -5)


				),
				new ASStruc().setFrameRate(0).setSmall().setFrames(
						new ASFrame().setLocation(0, 0.02, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:pinguin_head", "654121131bb69578ee2a7e5ca115f49b6b071a68ef0cfee9b027058e77fa4351").setHeadPos(0, 0, 0)

				)));
		CosmAPI.registerPet(new Pet(11, "pet:bb8", "42d271f82674916dcb47b372a572f61e7472fe063b2c9246aeeb7c57a8835", "§7BB8","§7Vient BB8 , on va botter les fesses de Snoke !", 1000,false,true,true,
				new ASStruc().setFrameRate(4).setFrames(
						new ASFrame().setHeadPos(0, 0, 270).setLocation(0.29, -1.1, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:bb8_body", "c856981ccec8a492898e0cb4d9443d21459d5b65dfa8da462d17697a178f8e"),
						new ASFrame().setHeadPos(0, 22.5, 270),
						new ASFrame().setHeadPos(0, 45, 270),
						new ASFrame().setHeadPos(0, 67.5, 270)
				),
				new ASStruc().setFrameRate(0).setSmall().setFrames(
						new ASFrame().setLocation(0, -0.05, -0.1).setHead(new ItemStack(Material.PLAYER_HEAD,1, (short) 3), "pet:bb8_head", "42d271f82674916dcb47b372a572f61e7472fe063b2c9246aeeb7c57a8835").setHeadPos(0, 0, 0)

				)));
		CosmAPI.registerPet(new Pet(12, "pet:sun", "c11234820a1e7bfb912b522aecf34bfcb569f02bf5836e669a29bae99737e522", "§7Système solaire","§7Pour une fois , vous êtes le centre du système solaire !",1000,true,false,false,
				new ASStruc(){
					@Override
					public void update(CurrentPet cpet, ASData data, Player p) {
						data.ent.getWorld().spawnParticle(Particle.FLAME, data.ent.getLocation().add(0, 1.3, 0), 4, 0.15, 0.1, 0.15, 0.1);
						super.update(cpet, data,p);
					}
				}.setFrameRate(0).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(0,1,0).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:sun", "c11234820a1e7bfb912b522aecf34bfcb569f02bf5836e669a29bae99737e522")

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(0,1,-2.5).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:earth", "2e2cc42015e6678f8fd49ccc01fbf787f1ba2c32bcf559a015332fc5db50"),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(-1.77,1,1.77).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:saturn", "665cd3a24f193371eebac9a71c48f408a935afc4b435f1fb7b9843e6587298f"),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(-1.77,1,-1.77).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:mars", "777d616bc44ac9b3730fed47f29a378f88a16728c67048c1a387d229e1cba"),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(-2.5,1,0).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:jupiter", "b8aaa8a3561e80ef1f9561f17211e770de18a9f98c2691ecf9d696559a1b918c"),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(2.5,1,0).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:mercury", "97fb27a1a11ba456c0a13f90901364ced9ecad8fe9c99b6838ff5f4dab1f6191"),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77)
				),

				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(1.77,1,-1.77).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:venus", "0ef147ddc908e6825c229997aa529761f51691a11c955129a233632d554875e"),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(1.77,1,1.77).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:neptune", "87d66f93909a6d4641c653082e04749691de82cf77232bd20ab32adf4f"),
						new ASFrame().setLocation(0,1,2.5),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0)

				),
				new ASStruc().setFrameRate(7).setFrames(
						new ASFrame().setHeadPos(0,0,0).setLocation(0,1,2.5).setHead(new ItemStack(Material.PLAYER_HEAD, 1,(short)3),"pet:uranus", "aa6dd75f41e4268e0a1269050907aa6746ffd37a4a929e732524642c336bc"),
						new ASFrame().setLocation(-1.77,1,1.77),
						new ASFrame().setLocation(-2.5,1,0),
						new ASFrame().setLocation(-1.77,1,-1.77),
						new ASFrame().setLocation(0,1,-2.5),
						new ASFrame().setLocation(1.77,1,-1.77),
						new ASFrame().setLocation(2.5,1,0),
						new ASFrame().setLocation(1.77,1,1.77)
				)));


	}

	public static double angle(double a){
		if(a>0)return a;
		else return 180+a+180;
	}

	public static ItemStack getSkull(ItemStack item, String uuidstr, String texture){
		SkullMeta smeta = (SkullMeta)item.getItemMeta();
		ItemUtils.setProfile(smeta, ItemUtils.genProfile(uuidstr, texture));
		item.setItemMeta(smeta);
		return item;

	}

	public static void spawnPet(Player p, Pet pet){

		if(CosmAPI.playerCache.containsKey(p.getUniqueId())){
			if(CosmAPI.playerCache.get(p.getUniqueId()) != null){
				CosmeticPlayer cosp = CosmAPI.playerCache.get(p.getUniqueId());
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
		CosmAPI.getCosPlay(p).pet = cp;
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
