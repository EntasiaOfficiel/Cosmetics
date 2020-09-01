package fr.entasia.cosmetics.utils.particles;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Particle {


    Particle(int id, ItemStack item, String name, String description, int price, ParticleStruct... structs){
        this.price = price;
        this.id = id;
        this.itemStack = item;
        this.name = name;
        this.description = description;
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        this.structs = structs;
    }

    public int id;
    public ItemStack itemStack;
    public int price;
    public String name;
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
