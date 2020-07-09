package fr.entasia.cosmetiques.utils.particles;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Particle {


    Particle(int id, ItemStack item, String nom,String description, int price, ParticleStruct... structs){
        this.price = price;
        this.id = id;
        this.itemStack = item;
        this.nom = nom;
        this.description = description;
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(nom);
        itemStack.setItemMeta(meta);
        this.structs = structs;
    }

    public int id;
    public ItemStack itemStack;
    public int price;
    public String nom;
    public String description;
    public ParticleStruct[] structs;





    public void update(Location loc){
        for(ParticleStruct s : structs){
            if(s.framecounter==0){
                s.update(loc);
            }
        }
    }
}
