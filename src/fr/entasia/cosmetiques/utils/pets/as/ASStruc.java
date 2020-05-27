package fr.entasia.cosmetiques.utils.pets.as;

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

}
