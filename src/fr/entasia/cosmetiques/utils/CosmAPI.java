package fr.entasia.cosmetiques.utils;

import fr.entasia.cosmetiques.Main;
import fr.entasia.cosmetiques.utils.particles.Particle;
import fr.entasia.cosmetiques.utils.pets.Pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CosmAPI {

	public static HashMap<UUID, CosmeticPlayer> playerCache = new HashMap<>();
	public static ArrayList<Particle> particleList = new ArrayList<Particle>();
	public static ArrayList<Pet> petList = new ArrayList<Pet>();


	public static void registerParticle(Particle particle){
		particleList.add(particle);
	}

	public static void registerPet(Pet pet){
		petList.add(pet);
	}

	public static boolean haveCosm(Integer id, UUID uuid, Boolean isPet) {
		try {

			Main.sql.checkConnect();
			PreparedStatement ps;

			if(isPet) ps = Main.sql.connection.prepareStatement("SELECT id FROM pets where uuid=?");
			else ps = Main.sql.connection.prepareStatement("SELECT id FROM particles where uuid=?");

			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public static void unlockParticle(int id, UUID uuid){
		Main.sql.checkConnect();
		PreparedStatement ps;
		try {
			ps = Main.sql.connection.prepareStatement("INSERT INTO particles(uuid,id) VALUES (?,?)");
			ps.setInt(2, id);
			ps.setString(1, uuid.toString());
			ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void unlockPet(int id, UUID uuid){
		Main.sql.checkConnect();
		PreparedStatement ps;
		try {
			ps = Main.sql.connection.prepareStatement("INSERT INTO pets(uuid,id) VALUES (?,?)");
			ps.setInt(2, id);
			ps.setString(1, uuid.toString());
			ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}