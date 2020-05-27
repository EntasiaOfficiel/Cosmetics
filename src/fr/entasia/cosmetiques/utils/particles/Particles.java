package fr.entasia.cosmetiques.utils.particles;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public enum Particles {

	ANGEL_HALO(301, new ItemStack(Material.GLOWSTONE), "§7Auréole d'ange","§7Manque plus que les ailes et on dirait un vrai",3200,
			new ParticleStruct() {
				@Override
				public void update(Location location) {
					for(Location loc : getCirclePoints(15,0.5,location)){
						location.getWorld().spawnParticle(Particle.REDSTONE,loc,0, 1, 1, 0.4,1);
					}

				}
			}.setFrameRate(2)
	),

	COLORED_HALO(302, new ItemStack(Material.REDSTONE), "§7Auréole colorée","§7C'est juste... de la couleur qui tourne",3200,
			new ParticleStruct() {

				public int maxInc = 15;
				public int inc=1;
				@Override
				public void update(Location location) {
					Random random = new Random();
					final float hue = random.nextFloat();
					final float saturation = (random.nextInt(2000) + 1000) / 10000f;
					final float luminance = 0.9f;
					final Color color = Color.getHSBColor(hue, saturation, luminance);
					ArrayList<Location> locs = getCirclePoints(15,0.5,location);

					location.getWorld().spawnParticle(Particle.REDSTONE,locs.get(inc),0, color.getRed(),color.getGreen(),color.getBlue(),1);
					inc++;
					if(inc>=maxInc) inc=0;

				}
			}.setFrameRate(1),
			new ParticleStruct() {

				public final int maxInc = 15;
				public int inc=2;
				public double color;
				@Override
				public void update(Location location) {
					color += 0.01;
					if(color==1)color = 0.02;
					ArrayList<Location> locs = getCirclePoints(15,0.5,location);
					location.getWorld().spawnParticle(Particle.REDSTONE,locs.get(inc),0, color, color, color,1);
					inc++;
					if(inc>=maxInc) inc=0;


				}
			}.setFrameRate(1)
	),
	MUSIC_CIRCLE(303, new ItemStack(Material.JUKEBOX), "§7Auréole musicale","§7Vivez la vie en musique !",3200,
			new ParticleStruct() {

				public double inc=0;
				public double color;
				@Override
				public void update(Location location) {
					Location finalLocation = location.add(0,inc,0);
					color += 0.01;
					if(color==1)color = 0.02;
					for(Location loc : getCirclePoints(15,0.5,finalLocation)){
						location.getWorld().spawnParticle(Particle.NOTE,loc,0, color, color, color,1);
					}
					/*if(inc<=-2){
						ascend=true;
					} else if(inc>=0){
						ascend=false;
					}
					if(ascend){
						inc=inc+0.1;
					} else {
						inc=inc-0.1;
					}*/

				}
			}.setFrameRate(5)
	),
	MAGIC_WALK_TRAIL(304, new ItemStack(Material.ENCHANTMENT_TABLE), "§7Trainée magique","§7Je suis ... Doctor Strange",3200,
			new ParticleStruct() {

				@Override
				public void update(Location loce) {
					Location location = loce.add(0,-2,0);
					for(Location loc : getCirclePoints(15,0.5,location)){
						location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,loc,0,0,0,0,1);
					}
					for(Location loc : getCirclePoints(15,0.4,location)){
						location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,loc,0,0,0,0,1);
					}
					for(Location loc : getCirclePoints(15,0.3,location)){
						location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,loc,0,0,0,0,1);
					}
					for(Location loc : getCirclePoints(15,0.2,location)){
						location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,loc,0,0,0,0,1);
					}
					for(Location loc : getCirclePoints(15,0.1,location)){
						location.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE,loc,0,0,0,0,1);
					}



				}
			}.setFrameRate(1)
	),
	FLAME_ROUND(305, new ItemStack(Material.FLINT_AND_STEEL), "§7Aura de feu","§7Attention ça brule",3200,
			new ParticleStruct() {
				double t = 0;
				double r = 1;
				boolean ascend= true;

				boolean middle=false;

				@Override
				public void update(Location loc) {

					t = t + Math.PI/8;
					double x = r*Math.cos(t);
					double y = 0.5*t;
					double z = r*Math.sin(t);
					double finalY = y;
					double finalZ = z;
					double finalX = x;
					if(!ascend){
						finalY= -y+Math.PI;
						finalZ = z;
						finalX = -x;
					}
					if(middle){
						finalZ=0;
						finalX=0;
					}
					loc.add(finalX, finalY, finalZ);
					loc.getWorld().spawnParticle(Particle.FLAME, loc,0,0,0,0,1);
					if (t > Math.PI*2){
						if(ascend){
							if(middle){
								middle=false;
								ascend=false;
								t=0;
							} else middle=true;
						}else{
							if(middle){
								middle=false;
								ascend=true;
								t=0;
							} else middle=true;
						}
					}
				}
			}.setFrameRate(1)
	),
	NYAN_CAT(306, new ItemStack(Material.MONSTER_EGG,1, EntityType.OCELOT.getTypeId()), "§7Nyan Cat","§7N'avez-vous jamais rêvé d'être un Nyan Cat ?",3200,
			new ParticleStruct() {

				@Override
				public void update(Location loc) {
					for (int i = 0; i < 15; ++i) {
						Random random = new Random();
						final float hue = random.nextFloat();
						final float saturation = (random.nextInt(2000) + 1000) / 10000f;
						final float luminance = 0.9f;
						final Color color = Color.getHSBColor(hue, saturation, luminance);
						loc.getWorld().spawnParticle(Particle.REDSTONE, loc,0, color.getRed(), color.getGreen(), color.getBlue(),1);
						loc.setY(loc.getY() + 0.1);
					}



				}
			}.setFrameRate(1)
	),

	HEAL_AURA(307, new ItemStack(Material.EMERALD), "§7Aura de soin","§7Aaah , ça fait du bien un peu de soin",3200,
			new ParticleStruct() {

				@Override
				public void update(Location loc) {
					loc.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc.add(0,0.7,0),1,0.5,0.5,0.5,1);



				}
			}.setFrameRate(1)
	),

	HEART_AURA(308, new ItemStack(Material.WOOL,1,(byte) 14), "§7Aura de coeur","§7Partagez un peu d'amour avec les autres joueurs",3200,
			new ParticleStruct() {

				@Override
				public void update(Location loc) {
					loc.getWorld().spawnParticle(Particle.HEART, loc.add(0,0.7,0),1,0.5,0.5,0.5,1);



				}
			}.setFrameRate(1)
	),

	POTION_CIRCLE(309, new ItemStack(Material.POTION), "§7Cercle de potion","§7Je crois que la potion était périmée",3200,
			new ParticleStruct() {

				public double inc=0;
				public boolean ascend = false;

				@Override
				public void update(Location location) {
					Location finalLocation = location.add(0,inc,0);
					int r = Integer.parseInt(String.valueOf(Math.round(Math.random() * 255)));
					int g = Integer.parseInt(String.valueOf(Math.round(Math.random() * 255)));
					int b = Integer.parseInt(String.valueOf(Math.round(Math.random() * 255)));

					Color color = new Color(r, g, b);

					for(Location loc : getCirclePoints(15,0.5,finalLocation)){
						location.getWorld().spawnParticle(Particle.SPELL_MOB,loc,0, color.getRed(), color.getGreen(), color.getBlue(),1);
					}

					if(inc<=-2){
						ascend=true;
					} else if(inc>=0){
						ascend=false;
					}
					if(ascend){
						inc=inc+0.1;
					} else {
						inc=inc-0.1;
					}

				}


			}.setFrameRate(2)
	),

	CROWN(310, new ItemStack(Material.GOLD_BLOCK), "§7Couronne","§7Je suis le roi !",3200,
			new ParticleStruct() {

				@Override
				public void update(Location location) {
					for(Location loc : getCirclePoints(15,0.35,location)){
						location.getWorld().spawnParticle(Particle.REDSTONE,loc,0, 1, 1, 0,1);
					}
					for(Location loc : getCirclePoints(6,0.35,location.add(0,0.15,0))){
						location.getWorld().spawnParticle(Particle.REDSTONE,loc,0, 1, 0, 0,1);
					}
				}
			}.setFrameRate(2)
	);



	public ParticleType type;

	public static Particles getByID(int id){
		for(Particles c : Particles.values()){
			if(c.id==id)return c;
		}
		return null;
	}

	public static ItemStack getItemStack(int id){
		for(Particles c : Particles.values()){
			if(c.id==id)return c.itemStack;
		}
		return null;
	}

	public void update(Location loc){
		for(ParticleStruct s : structs){
			if(s.framecounter==0){
				s.update(loc);
			}
		}
	}

	public int id;
	public ItemStack itemStack;
	public int price;
	public String nom;
	public String description;
	public ParticleStruct[] structs;

	Particles(int id, ItemStack item, String nom,String description, int price, ParticleStruct... structs){
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

	public static ArrayList<Location> getCirclePoints(int points, double radius, Location center){
		double slice = 2 * Math.PI / points;
		ArrayList<Location> locs = new ArrayList<>();
		for (int i = 0; i < points; i++)
		{
			double angle = slice * i;
			double newX = (center.getX() + radius * Math.cos(angle));
			double newZ = (center.getZ() + radius * Math.sin(angle));
			locs.add(new Location(center.getWorld(),newX,center.getY()+2,newZ));


		}
		return locs;
	}





}
