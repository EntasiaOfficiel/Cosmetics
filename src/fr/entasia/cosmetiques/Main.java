package fr.entasia.cosmetiques;


import fr.entasia.apis.sql.SQLConnection;
import fr.entasia.apis.utils.ServerUtils;
import fr.entasia.cosmetiques.listeners.Base;
import fr.entasia.cosmetiques.utils.CosmeticPlayer;
import fr.entasia.cosmetiques.utils.CosmAPI;
import fr.entasia.cosmetiques.utils.others.RecurrentTask;
import fr.entasia.cosmetiques.utils.particles.ParticleUtils;
import fr.entasia.cosmetiques.utils.pets.CurrentPet;
import fr.entasia.cosmetiques.utils.pets.PetsUtils;
import fr.entasia.cosmetiques.utils.pets.as.ASData;
import fr.entasia.cosmetiques.versions.IPathFinder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main main;

	public static IPathFinder multiversion;

	public static SQLConnection sql;
	@Override
	public void onEnable() {
		try{

			sql = new SQLConnection("cosmetiques","global");
			main = this;
			getLogger().info("Activation du plugin...");
			ParticleUtils.registerAllParticle();
			PetsUtils.registerAllPet();
			Class<?> cl = Class.forName("fr.entasia.cosmetiques.versions."+ ServerUtils.getVersionStr());
			multiversion = (IPathFinder) cl.newInstance();

			new RecurrentTask().runTaskTimerAsynchronously(this, 0, 1);

	        Bukkit.getServer().getPluginManager().registerEvents(new Base(), this);



			getLogger().info("Plugin activé !");
		}catch(ClassNotFoundException e) {
			getLogger().severe("Le serveur ne correspond pas à une version enregistrée dans \"versions\"! ");
			getLogger().severe("UNE ERREUR EST SURVENUE ! ARRET DU SERVEUR");
			getServer().shutdown();
		}catch(Throwable e){
			e.printStackTrace();
			getLogger().severe("UNE ERREUR EST SURVENUE ! ARRET DU SERVEUR");
			getServer().shutdown();
		}



	}

	@Override
	public void onDisable(){
		//Faire despawn les pets de tous les joueurs
		for (CosmeticPlayer cp: CosmAPI.playerCache.values()) {
			if(cp.hasPet()){
				CurrentPet pet = cp.pet;
				pet.origin.remove();
				for(ASData asd : pet.armor_stands){
					asd.ent.remove();
				}
			}
		}
	}
}