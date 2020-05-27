package fr.entasia.cosmetiques.utils.particles;

import org.bukkit.Location;

public abstract class ParticleStruct {

    public int framecounter=0;
    public int framerate=0;


    public ParticleStruct setFrameRate(int framerate){
        this.framerate = framerate;
        return this;
    }

    public abstract void update(Location loc);



}
