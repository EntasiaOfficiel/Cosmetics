package fr.entasia.cosmetiques.utils;

import fr.entasia.apis.MoneyUtils;
import fr.entasia.apis.menus.MenuClickEvent;
import fr.entasia.apis.menus.MenuCreator;
import fr.entasia.apis.sql.SQLConnection;
import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.particles.Particles;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.Pets;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			for(Particles c : Particles.values()){
				if(c.itemStack.getItemMeta().getDisplayName().equals(e.item.getItemMeta().getDisplayName())){
					if(Utils.haveCosm(c.id,e.player.getUniqueId(), false)){
						e.player.sendMessage("§7Vous avez activé la particule "+c.nom);
						CosmeticPlayer.getCosPlay(e.player).particle = c;
						e.player.closeInventory();
					} else{
						e.player.closeInventory();
						openParticleBuyMenu(e.player,c);

					}
					return;
				}
			}
			if(e.item.getItemMeta().getDisplayName().equals("§cRetour")){
				cosmMenuOpen(e.player);
			}else if(e.item.getItemMeta().getDisplayName().equals("§cEnlever les particules")){
				CosmeticPlayer c = CosmeticPlayer.getCosPlay(e.player);
				if(c.particle==null)e.player.sendMessage("§7Vous n'avez pas de particule activée !");
				else{
					c.particle = null;
					e.player.sendMessage("§7Vous avez enlevé votre particule");
				}
			}
			e.player.closeInventory();
		}
	};

	public static void particleMenuOpen(Player p){

		int cosm = 0;
		for(Particles c : Particles.values()){
			cosm++;
		}
		int slot = cosm*2;
		while( slot%9!=0){
			slot++;
		}

		Inventory inv = particleMenu.createInv(slot/9, "§7Menu des particules");
		int nextSlot = 1;
		for(Particles c : Particles.values()){
			ItemStack item = c.itemStack.clone();
			ItemMeta meta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<>(Collections.singletonList(c.description));

			if(!Utils.haveCosm(c.id,p.getUniqueId(), false)){
				lore.add("§cVous n'avez pas encore débloqué cette particule");
			}else{

				lore.add("§aVous possédez cette particule");
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
			}
			if(item.getType().equals(Material.POTION)){
				meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			}
			meta.setDisplayName(c.nom);
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(nextSlot, item);
			nextSlot= nextSlot+2;
		}
		ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta meta=  item.getItemMeta();
		meta.setDisplayName("§cEnlever les particules");
		item.setItemMeta(meta);
		inv.setItem(slot-1,item);

		p.openInventory(inv);
	}


	public static MenuCreator petMenu = new MenuCreator(){
		@Override
		public void onMenuClick(MenuClickEvent e){
			for(Pets c : Pets.values()){
				if(c.name.equalsIgnoreCase(e.item.getItemMeta().getDisplayName())){
					if(Utils.haveCosm(c.id,e.player.getUniqueId(), true)){
						e.player.sendMessage("§7Vous avez activé le pet "+c.name);
						PetsUtils.spawnPet(e.player, c);
						e.player.closeInventory();
					} else{
						e.player.closeInventory();
						openPetBuyMenu(e.player,c);

					}
					return;
				}
			}
			if(e.item.getItemMeta().getDisplayName().equals("§cRetour")){
				cosmMenuOpen(e.player);
			}else if(e.item.getItemMeta().getDisplayName().equals("§cEnlever le pet")){
				CosmeticPlayer c = CosmeticPlayer.getCosPlay(e.player);
				if(c.pet==null)e.player.sendMessage("§7Vous n'avez pas de pet activé !");
				else{
					CurrentPet cPet = c.pet;
					c.pet = null;
					cPet.origin.remove();
					for(ASData asd : cPet.armor_stands){
						asd.ent.remove();
					}
					e.player.sendMessage("§7Vous avez enlevé votre pet");
				}
			}
			e.player.closeInventory();
		}
	};

	public static void petMenuOpen(Player p){

		int pets = 0;
		for(Pets pet : Pets.values()){
			pets++;
		}
		int slot = pets*2;
		while( slot%9!=0){
			slot++;
		}

		Inventory inv = petMenu.createInv(slot/9, "§7Menu des Pets");
		int nextSlot = 1;
		for(Pets c : Pets.values()){

			ItemStack item = c.itemStack.clone();
			ItemMeta meta = item.getItemMeta();
			ArrayList<String> lore = new ArrayList<>(Collections.singletonList(c.description));

			if(!Utils.haveCosm(c.id,p.getUniqueId(), true)){
				lore.add("§cVous n'avez pas encore débloqué ce Pet");
			}else{
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.addEnchant(Enchantment.LURE, 1, false);
				lore.add("§aVous possédez ce Pet");
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
		ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta meta=  item.getItemMeta();
		meta.setDisplayName("§cEnlever le pet");
		item.setItemMeta(meta);
		inv.setItem(slot-1,item);

		p.openInventory(inv);
	}







	public static MenuCreator buyParticleMenu = new MenuCreator() {

		@Override
		public void onMenuClick(MenuClickEvent e){
			if(e.item.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler")){


				e.player.closeInventory();
				e.player.sendMessage("§cAchat annulé");
				return;
			}
			UUID uuid = e.player.getUniqueId();
			Particles c = (Particles)e.data;
			if(MoneyUtils.getMoney(uuid)>= c.price){
				MoneyUtils.removeMoney(uuid, c.price);
				e.player.sendMessage("§2Vous avez acheté la particule "+c.nom);
				e.player.closeInventory();
				Main.sql.checkConnect();
				PreparedStatement ps;
				try {
					ps = Main.sql.connection.prepareStatement("INSERT INTO particles(uuid,id) VALUES (?,?)");
					ps.setInt(2, c.id);
					ps.setString(1, e.player.getUniqueId().toString());
					ps.execute();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			} else {
				e.player.sendMessage("§4Vous n'avez pas assez d'argent pour acheter cette particule");
				e.player.closeInventory();
			}

		}
	};

	public static void openParticleBuyMenu(Player p, Particles c){
		Inventory inv = buyParticleMenu.createInv(2,"§7Achat d'une particule", c);

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

	public static MenuCreator buyPetMenu = new MenuCreator() {

		@Override
		public void onMenuClick(MenuClickEvent e){
			if(e.item.getItemMeta().getDisplayName().equalsIgnoreCase("§cAnnuler")) e.player.closeInventory();
			UUID uuid = e.player.getUniqueId();
			Pets c = (Pets)e.data;
			if(MoneyUtils.getMoney(uuid)>= c.price){
				MoneyUtils.removeMoney(uuid, c.price);
				e.player.sendMessage("§2Vous avez acheté le pet "+c.name);
				e.player.closeInventory();
				Main.sql.checkConnect();
				PreparedStatement ps;
				try {
					ps = Main.sql.connection.prepareStatement("INSERT INTO pets(uuid,id) VALUES (?,?)");
					ps.setInt(2, c.id);
					ps.setString(1, e.player.getUniqueId().toString());
					ps.execute();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			} else {
				e.player.sendMessage("§4Vous n'avez pas assez d'argent pour acheter ce Pet");
				e.player.closeInventory();
			}

		}
	};

	public static void openPetBuyMenu(Player p, Pets c){
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
