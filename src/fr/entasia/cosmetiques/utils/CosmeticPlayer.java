package fr.entasia.cosmetiques.utils;

import fr.entasia.cosmetiques.utils.particles.Particles;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import org.bukkit.entity.Player;

public class CosmeticPlayer {

    public Player p;

    public CurrentPet pet; // pet actuel
    public Particles particle; // particule actuelle


    public CosmeticPlayer(Player p){
        this.p = p;
    }

    public boolean hasPet(){
        return pet!=null;
    }
    public boolean hasParticle(){
        return particle!=null;
    }

    public static CosmeticPlayer getCosPlay(Player p){
        CosmeticPlayer cp = Utils.playerCache.get(p.getUniqueId());
        if(cp==null){
            cp = new CosmeticPlayer(p);
            Utils.playerCache.put(p.getUniqueId(), cp);
        }
        return cp;
    }




}
