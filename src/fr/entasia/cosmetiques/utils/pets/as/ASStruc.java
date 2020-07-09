package fr.entasia.cosmetiques.utils.pets.as;

import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class ASStruc {

	public ArrayList<ASFrame> frames = new ArrayList<>();

	public boolean small=false;
	public int framerate=0;


	public ASStruc setFrameRate(int framerate){
		this.framerate = framerate;
		return this;
	}
	public ASStruc setSmall(){
		small=true;
		return this;
	}

	public ASStruc setFrames(ASFrame... fr){
		frames.addAll(Arrays.asList(fr));
		return this;
	}


	public void update(CurrentPet cpet, ASData data, Player p){
		// ANIMATION - 1 : Frame checking
		ASFrame frame;
		if(framerate!=0){
			int frameID = data.getCurrentFrameID();

			if(cpet.type.moveOnly&&frameID==0){
				if(cpet.origin.getLocation().equals(cpet.lastloc))return;
				cpet.lastloc = cpet.origin.getLocation();
			}

			data.addTickN();

			frame = data.struct.frames.get(frameID);

			PetsUtils.updateAS(data, frame); // ANIMATION - 2


		}else frame = frames.get(0);


		// ROTATION - 1
		double anglePoulet = PetsUtils.angle(cpet.origin.getLocation().getYaw());
		Vector vector = frame.rloc;

		// ROTATION - 2 : Si la frame ne contient pas de position on se base sur la position de la dernière frame, enregistrée dans asd.lastrloc
		if(frame.rloc==null){
			if(data.lastrloc==null){
				Main.main.getLogger().severe("Pet non valide : "+cpet.type.name+" : Pas de location pour la première frame !");
				return;
			}else if(!cpet.type.norotate) vector = PetsUtils.rotate(data.lastrloc, anglePoulet);
		}else{

			if(!cpet.type.norotate)vector = PetsUtils.rotate(frame.rloc, anglePoulet);
			data.lastrloc = frame.rloc;	}

		Location a = cpet.origin.getLocation().add(vector);
		a.setYaw(a.getYaw()+frame.locrotation);
		new BukkitRunnable(){
			@Override
			public void run() {
				data.ent.teleport(a);
				if(cpet.origin.getWorld() != data.ent.getWorld()){
					Main.multiversion.setPathGoal(cpet.origin, p);
				}
				cancel();
			}
		}.runTask(Main.main);



	}

}
