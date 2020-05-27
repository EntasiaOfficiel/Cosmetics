package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.apis.ItemUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class ASFrame {

	public Vector rloc;

	public ItemStack head;
	public EulerAngle headpos = new EulerAngle(0,0,0);

	public EulerAngle rightarmpos = new EulerAngle(0,0,0);
	public ItemStack rightarm;

	public EulerAngle leftarmpos = new EulerAngle(0,0,0);
	public ItemStack leftarm;

	public boolean small=false;


	public ASFrame(double rx, double ry, double rz){
		this.rloc = new Vector(rx, ry, rz);
	}

	// TÊTE

	public ASFrame setHead(ItemStack item){
		this.head=item;
		return this;
	}

	public ASFrame setHead(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.head=item;
		return this;
	}

	public ASFrame setHeadPos(double x, double y, double z){
		this.headpos = new EulerAngle(x, y, z);
		return this;
	}

	// BRAS DROIT

	public ASFrame setRightArmPos(double x, double y, double z){
		this.rightarmpos = new EulerAngle(x, y, z);
		return this;
	}

	public ASFrame setRightArm(ItemStack item){
		this.rightarm=item;
		return this;
	}

	public ASFrame setRightArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.rightarm=item;
		return this;
	}

	// BRAS GAUCHE

	public ASFrame setLeftArmPos(double x, double y, double z){
		this.leftarmpos = new EulerAngle(x, y, z);
		return this;
	}

	public ASFrame setLeftArm(ItemStack item){
		this.leftarm=item;
		return this;
	}

	public ASFrame setLeftArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.head=item;
		return this;
	}

	// AUTRES

	public ASFrame setSmall(){
		small=true;
		return this;
	}

}
