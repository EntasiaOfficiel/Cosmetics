package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.apis.ItemUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class ASStruc {

	public Vector rloc;

	public ItemStack head;
	public EulerAngle headpos = new EulerAngle(0,0,0);

	public EulerAngle rightarmpos = new EulerAngle(0,0,0);
	public ItemStack rightarm;

	public EulerAngle leftarmpos = new EulerAngle(0,0,0);
	public ItemStack leftarm;

	public boolean small=false;


	public ASStruc(double rx, double ry, double rz){
		this.rloc = new Vector(rx, ry, rz);
	}

	// TÊTE

	public ASStruc setHead(ItemStack item){
		this.head=item;
		return this;
	}

	public ASStruc setHead(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.head=item;
		return this;
	}

	public ASStruc setHeadPos(double x, double y, double z){
		this.headpos = new EulerAngle(x, y, z);
		return this;
	}

	// BRAS DROIT

	public ASStruc setRightArmPos(double x, double y, double z){
		this.rightarmpos = new EulerAngle(x, y, z);
		return this;
	}

	public ASStruc setRightArm(ItemStack item){
		this.rightarm=item;
		return this;
	}

	public ASStruc setRightArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.rightarm=item;
		return this;
	}

	// BRAS GAUCHE

	public ASStruc setLeftArmPos(double x, double y, double z){
		this.leftarmpos = new EulerAngle(x, y, z);
		return this;
	}

	public ASStruc setLeftArm(ItemStack item){
		this.leftarm=item;
		return this;
	}

	public ASStruc setLeftArm(ItemStack item, String texture){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		ItemUtils.setTexture(meta, texture);
		item.setItemMeta(meta);
		this.head=item;
		return this;
	}

	// AUTRES

	public ASStruc setSmall(){
		small=true;
		return this;
	}

}
