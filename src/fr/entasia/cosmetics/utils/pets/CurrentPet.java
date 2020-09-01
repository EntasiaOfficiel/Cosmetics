package fr.entasia.cosmetics.utils.pets;

import fr.entasia.cosmetics.utils.pets.as.ASData;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;

import java.util.ArrayList;

public class CurrentPet {


	public Pet type;
	public ArrayList<ASData> armor_stands = new ArrayList<>();
	public Chicken origin;
	public Location lastloc;


    public CurrentPet(Pet type){
		this.type = type;
	}
}
