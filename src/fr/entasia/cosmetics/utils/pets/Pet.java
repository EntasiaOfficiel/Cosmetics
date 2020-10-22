package fr.entasia.cosmetics.utils.pets;

import fr.entasia.cosmetics.utils.pets.as.ASStruc;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pet {

    Pet(int id, String uuidstr, String texture, String name, String description, int price, boolean norotate, boolean moveOnly,boolean safe, ASStruc... data){
        this.safe = safe;
        this.norotate=norotate;
        this.description= description;
        this.id = id;
        this.itemStack = PetsUtils.getSkull(new ItemStack(Material.PLAYER_HEAD, 1, (short)3), uuidstr, texture);
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
