package fr.entasia.cosmetiques.utils.pets.as;

import org.bukkit.entity.ArmorStand;
import org.bukkit.util.Vector;

public class ASData {

	public ArmorStand ent;
	public ASStruc struct;
	public Vector lastrloc;
	public int tickn=0;

	public ASData(ASStruc struct){
		this.struct = struct;
	}

	public int getCurrentFrameID(){
		return tickn/struct.framerate;
	}

	public void addTickN(){
		tickn++;
		if(tickn/struct.framerate>=struct.frames.size())tickn=0;
	}

}
