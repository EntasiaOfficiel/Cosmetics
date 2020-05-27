package fr.entasia.cosmetiques.utils;

import fr.entasia.cosmetiques.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Utils {

	public static HashMap<UUID, CosmeticPlayer> playerCache = new HashMap<>();

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
}