package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.cosmetiques.utils.pets.as.ASStruc;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pet {

    Pet(int id, ItemStack item, String name, String description, int price,boolean norotate, boolean moveOnly,boolean safe, ASStruc... data){
        this.safe = safe;
        this.norotate=norotate;
        this.description= description;
        this.id = id;
        this.itemStack = item;
        this.name = name;
        ItemMeta meta = itemStack.getItemMeta();
        itemStack.setItemMeta(meta);
        this.price = price;
        this.moveOnly = moveOnly;
        this.data = data;
    }

    public int id;
    public ItemStack itemStack;
    public String name;
    public int price;
    public boolean safe;
    public String description;
    public boolean moveOnly;
    public ASStruc[] data;
    public boolean norotate;



}
