package fr.entasia.cosmetiques.utils;

import fr.entasia.apis.menus.MenuClickEvent;
import fr.entasia.apis.menus.MenuCreator;
import fr.entasia.apis.other.ItemBuilder;
import fr.entasia.apis.utils.MoneyUtils;
import fr.entasia.cosmetiques.utils.particles.Particle;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.Pet;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class InvsManager {

	public static MenuCreator cosmMenu = new MenuCreator() {

		@Override
		public void onMenuClick(MenuClickEvent e){
		if(e.inv.getName().equalsIgnoreCase("§7Menu cosmétiques")){
			switch(e.item.getType()) {
				case MONSTER_EGG:{
					petMenuOpen(e.player);
					break;
				}
				case POTION:{
					particleMenuOpen(e.player);
					break;
				}
				default:{
					e.player.sendMessage("§7Ce menu n'existe pas");
					e.player.closeInventory();
				}
			}
		}
		}
	};

	@Deprecated // only deprecated for external use
	public static void cosmMenuOpen(Player p){
		Inventory inv = cosmMenu.createInv(1,"§7Menu cosmétiques");

		ItemStack itemPet = new ItemStack(Material.MONSTER_EGG, 1, EntityType.WOLF.getTypeId());
		ItemMeta petMeta = itemPet.getItemMeta();
		petMeta.setDisplayName("§7Menu des pets");
		itemPet.setItemMeta(petMeta);

		ItemStack itemParticle = new ItemStack(Material.POTION);
		ItemMeta particleMeta = itemParticle.getItemMeta();
		particleMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		particleMeta.setDisplayName("§7Menu des particules");
		itemParticle.setItemMeta(particleMeta);

		inv.setItem(1, itemPet);
		inv.setItem(7, itemParticle);

		p.openInventory(inv);

	}





	public static MenuCreator particleMenu = new MenuCreator(){
		@Override
		public void onMenuClick(MenuClickEvent e){
			for(Particle c : CosmAPI.particleList){
				if(c.itemStack.getItemMeta().getDisplayName().equals(e.item.getItemMeta().getDisplayName())){
					if(CosmAPI.haveCosm(c.id,e.player.getUniqueId(), false)){
						e.player.sendMessage("§aTu as activé la particule "+c.name+" !");
						CosmAPI.getCosPlay(e.player).particle = c;
						e.player.closeInventory();
					} else{
						openParticleBuyMenu(e.player, c);
					}
					return;
				}
			}
			switch(e.item.getType()){
				case REDSTONE_BLOCK:{
					CosmeticPlayer c = CosmAPI.getCosPlay(e.player);
					if(c.particle==null)e.player.sendMessage("§cTu n'as pas de particule activée !");
					else{
						c.particle = null;
						e.player.sendMessage("§aTu as enlevé ta particule");
					}
					break;
				}
				case BOOK_AND_QUILL:{
					cosmMenuOpen(e.player);
					break;
				}
			}
			e.player.closeInventory();
		}
	};

	public static void particleMenuOpen(Player p){

		int cosm = CosmAPI.particleList.size();
		int slot = cosm*2;
		while( slot%9!=0){
			slot++;
		}

		Inventory inv = particleMenu.createInv(slot/9, "§7Menu des particules");
		int nextSlot = 1;
		for(Particle c : CosmAPI.particleList){
			ItemStack item = c.itemStack.clone();
			ItemMeta meta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<>(Collections.singletonList(c.description));
			CosmeticPlayer cp = CosmAPI.getCosPlay(p);

			if(cp.particle!=null && cp.particle.equals(c)){
				lore.add("§6Cette particule est déjà activée");
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
			}else if(CosmAPI.haveCosm(c.id,p.getUniqueId(), false)){
				lore.add("§aTu possède cette particule");
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
			} else{
				lore.add("§cTu n'as pas encore débloqué cette particule");
			}

			if(item.getType().equals(Material.POTION)){
				meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			}
			meta.setDisplayName(c.name);
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(nextSlot, item);
			nextSlot= nextSlot+2;
		}

		ItemBuilder item = new ItemBuilder(Material.REDSTONE_BLOCK).lore("§cEnlever les particules");
		inv.setItem(slot-2, item.build());

		item = new ItemBuilder(Material.BOOK_AND_QUILL).lore("§cRetour au menu précédent");
		inv.setItem(slot-1, item.build());

		p.openInventory(inv);
	}


	public static MenuCreator petMenu = new MenuCreator(){
		@Override
		public void onMenuClick(MenuClickEvent e){
			for(Pet c : CosmAPI.petList){
				if(c.name.equalsIgnoreCase(e.item.getItemMeta().getDisplayName())){
					if(CosmAPI.haveCosm(c.id,e.player.getUniqueId(), true)){
						e.player.sendMessage("§aTu as activé le pet "+c.name);
						PetsUtils.spawnPet(e.player, c);
						e.player.closeInventory();
					} else{
						openPetBuyMenu(e.player,c);
					}
					return;
				}
			}

			switch(e.item.getType()){
				case REDSTONE_BLOCK:{
					CosmeticPlayer c = CosmAPI.getCosPlay(e.player);
					if(c.pet==null)e.player.sendMessage("§cTu n'as pas de pet activé !");
					else {
						CurrentPet cPet = c.pet;
						c.pet = null;
						cPet.origin.remove();
						for (ASData asd : cPet.armor_stands) {
							asd.ent.remove();
						}
						e.player.sendMessage("§aTu as enlevé ton pet");
					}
					break;
				}
				case BOOK_AND_QUILL:{
					cosmMenuOpen(e.player);
					break;
				}
			}
			e.player.closeInventory();
		}
	};

	public static void petMenuOpen(Player p){

		int pets = CosmAPI.petList.size();

		int slot = pets*2;
		while( slot%9!=0){
			slot++;
		}

		Inventory inv = petMenu.createInv(slot/9, "§7Menu des Pets");
		int nextSlot = 1;
		for(Pet c : CosmAPI.petList){

			ItemStack item = c.itemStack.clone();
			ItemMeta meta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<>(Collections.singletonList(c.description));
			CosmeticPlayer cp = CosmAPI.getCosPlay(p);


			if(cp.pet!=null && cp.pet.type.equals(c)){
				lore.add("§6Ce pet est déjà activé");
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
			}else if(CosmAPI.haveCosm(c.id,p.getUniqueId(), true)){
				lore.add("§aTu possède ce Pet");
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
			} else{
				lore.add("§cTu n'as pas encore débloqué ce Pet");
			}
			if(item.equals(new ItemStack(Material.POTION))){
				meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			}
			meta.setDisplayName(c.name);
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(nextSlot, item);
			nextSlot= nextSlot+2;

		}
		ItemBuilder item = new ItemBuilder(Material.REDSTONE_BLOCK).lore("§cEnlever le pet");
		inv.setItem(slot-2, item.build());

		item = new ItemBuilder(Material.BOOK_AND_QUILL).lore("§cRetour au menu précédent");
		inv.setItem(slot-1, item.build());

		p.openInventory(inv);
	}


	public static MenuCreator buyParticleMenu = new MenuCreator() {

		@Override
		public void onMenuClick(MenuClickEvent e){
			if(e.item.getType()==Material.REDSTONE_BLOCK){
				e.player.closeInventory();
				e.player.sendMessage("§cAchat annulé");
				return;
			}
			UUID uuid = e.player.getUniqueId();
			Particle c = (Particle)e.data;
			e.player.closeInventory();
			if(MoneyUtils.getMoney(uuid)>=c.price){
				MoneyUtils.removeMoney(uuid, c.price);
				CosmAPI.unlockParticle(c.id,e.player.getUniqueId());
				e.player.sendMessage("§aTu as acheté la particule "+c.name+" !");
				CosmAPI.getCosPlay(e.player).particle = c;

			} else {
				e.player.sendMessage("§cTu n'as pas assez d'argent pour acheter cette particule !");
			}

		}
	};

	public static void openParticleBuyMenu(Player p, Particle c){
		Inventory inv = buyParticleMenu.createInv(2,"§7Achat d'une particule", c);

		ItemStack cosmetique=c.itemStack;
		inv.setItem(4,cosmetique);
		ItemStack achat= new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 5);
		ItemMeta achatMeta= achat.getItemMeta();
		achatMeta.setDisplayName("§2Acheter");
		achatMeta.setLore(Collections.singletonList("§2Cout : "+c.price +" coins"));
		achat.setItemMeta(achatMeta);


		ItemStack refuser= new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta refuserMeta= refuser.getItemMeta();
		refuserMeta.setDisplayName("§cAnnuler");
		refuserMeta.setLore(Collections.singletonList("§cAnnuler l'achat"));
		refuser.setItemMeta(refuserMeta);

		inv.setItem(11,achat);
		inv.setItem(15,refuser);

		p.openInventory(inv);
	}

	public static MenuCreator buyPetMenu = new MenuCreator() {

		@Override
		public void onMenuClick(MenuClickEvent e){
			if(e.item.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler")) e.player.closeInventory();
			UUID uuid = e.player.getUniqueId();
			Pet c = (Pet)e.data;
			if(MoneyUtils.getMoney(uuid)>= c.price){
				MoneyUtils.removeMoney(uuid, c.price);
				e.player.sendMessage("§cTu as acheté le pet "+c.name);
				e.player.closeInventory();
				CosmAPI.unlockPet(c.id,e.player.getUniqueId());
			} else {
				e.player.sendMessage("§cTu n'as pas assez d'argent pour acheter ce Pet");
				e.player.closeInventory();
			}

		}
	};

	public static void openPetBuyMenu(Player p, Pet c){
		Inventory inv = buyPetMenu.createInv(2,"§7Achat d'un Pet", c);

		ItemStack cosmetique=c.itemStack;
		inv.setItem(4,cosmetique);
		ItemStack achat= new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 5);
		ItemMeta achatMeta= achat.getItemMeta();
		achatMeta.setDisplayName("§2Acheter");
		achatMeta.setLore(Collections.singletonList("§2Cout : "+c.price +" coins"));
		achat.setItemMeta(achatMeta);


		ItemStack refuser= new ItemStack(Material.STAINED_GLASS_PANE,1, (byte) 14);
		ItemMeta refuserMeta= refuser.getItemMeta();
		refuserMeta.setDisplayName("§cAnnuler");
		refuserMeta.setLore(Collections.singletonList("§cAnnuler l'achat"));
		refuser.setItemMeta(refuserMeta);

		inv.setItem(11,achat);
		inv.setItem(15,refuser);

		p.openInventory(inv);
	}
}
