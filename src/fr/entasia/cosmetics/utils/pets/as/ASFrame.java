package fr.entasia.cosmetics.utils.pets.as;

import fr.entasia.apis.utils.ItemUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.UUID;

public class ASFrame {

	public Vector rloc;
	public int locrotation;

	public ItemStack head;
	public EulerAngle headpos;

	public ItemStack rightarm;
	public EulerAngle rightarmpos;

	public ItemStack leftarm;
	public EulerAngle leftarmpos;

	public static EulerAngle translate(double a, double b, double c){
		return new EulerAngle(Math.toRadians(a), Math.toRadians(b), Math.toRadians(c));
	}

	public ASFrame setLocation(double rx, double ry, double rz){
		this.rloc = new Vector(rx, ry, rz);
		return this;
	}

	public ASFrame setRotation(int rotation){
		this.locrotation=rotation;
		return this;
	}

	// TÊTE

	public ASFrame setHead(ItemStack item){
		this.head=item;
		return this;
	}

	public ASFrame setHead(ItemStack item, String uuidstr, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setProfile(meta, ItemUtils.genProfile(uuidstr, texture));
		item.setItemMeta(meta);
		this.head = item;
		return this;
	}

	public ASFrame setHeadPos(double x, double y, double z){
		this.headpos = translate(x, y, z);
		return this;
	}

	// BRAS DROIT

	public ASFrame setRightArmPos(double x, double y, double z){
		this.rightarmpos = translate(x, y, z);
		return this;
	}

	public ASFrame setRightArm(ItemStack item){
		this.rightarm=item;
		return this;
	}

	public ASFrame setRightArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setProfile(meta, ItemUtils.genProfile(UUID.fromString("right-arm:pet"), texture));
		item.setItemMeta(meta);
		this.rightarm=item;
		return this;
	}

	// BRAS GAUCHE

	public ASFrame setLeftArmPos(double x, double y, double z){
		this.leftarmpos = translate(x, y, z);
		return this;
	}

	public ASFrame setLeftArm(ItemStack item){
		this.leftarm=item;
		return this;
	}

	public ASFrame setLeftArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setProfile(meta, ItemUtils.genProfile(UUID.fromString("left-arm:pet"), texture));
		item.setItemMeta(meta);
		this.head=item;
		return this;
	}
}
