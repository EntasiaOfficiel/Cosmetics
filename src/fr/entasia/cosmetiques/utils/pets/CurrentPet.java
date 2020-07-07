package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.cosmetiques.utils.pets.as.ASData;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;

import java.util.ArrayList;

public class CurrentPet {


	public Pets type;
	public ArrayList<ASData> armor_stands = new ArrayList<>();
	public Chicken origin;
	public Location lastloc;


    public CurrentPet(Pets type){
		this.type = type;
	}
}
