package fr.entasia.cosmetics;


import fr.entasia.apis.sql.SQLConnection;
import fr.entasia.apis.utils.ServerUtils;
import fr.entasia.cosmetics.listeners.Base;
import fr.entasia.cosmetics.utils.CosmeticPlayer;
import fr.entasia.cosmetics.utils.CosmAPI;
import fr.entasia.cosmetics.utils.others.RecurrentTask;
import fr.entasia.cosmetics.utils.particles.ParticleUtils;
import fr.entasia.cosmetics.utils.pets.CurrentPet;
import fr.entasia.cosmetics.utils.pets.PetsUtils;
import fr.entasia.cosmetics.utils.pets.as.ASData;
import fr.entasia.cosmetics.versions.IPathFinder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main main;

	public static IPathFinder multiversion;

	public static SQLConnection sql;
	@Override
	public void onEnable() {
		try{
			getLogger().info("Activation du plugin...");
			main = this;
			sql = new SQLConnection().mariadb("cosmetics","global");
			ParticleUtils.registerAllParticles();
			PetsUtils.registerAllPet();
			Class<?> cl = Class.forName("fr.entasia.cosmetics.versions."+ ServerUtils.getVersionStr());
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