package fr.entasia.cosmetiques.utils;

import fr.entasia.cosmetiques.utils.particles.Particle;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import org.bukkit.entity.Player;

public class CosmeticPlayer {

    public Player p;

    public CurrentPet pet; // pet actuel
    public Particle particle; // particule actuelle


    public CosmeticPlayer(Player p){
        this.p = p;
    }

    public boolean hasPet(){
        return pet!=null;
    }
    public boolean hasParticle(){
        return particle!=null;
    }

    @Deprecated
    public static CosmeticPlayer getCosPlay(Player p){
        CosmeticPlayer cp = CosmAPI.playerCache.get(p.getUniqueId());
        if(cp==null){
            cp = new CosmeticPlayer(p);
            CosmAPI.playerCache.put(p.getUniqueId(), cp);
        }
        return cp;
    }




}
