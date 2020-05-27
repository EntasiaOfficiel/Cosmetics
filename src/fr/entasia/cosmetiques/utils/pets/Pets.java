package fr.entasia.cosmetiques.utils.pets;

import fr.entasia.cosmetiques.utils.pets.as.ASFrame;
import fr.entasia.cosmetiques.utils.pets.as.ASStruc;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Pets {

	// UN CURRENTPET CONTIENT UNE ORIGINE ET DES ASDATA, QUI CONTIENNENT L'ENTITE DE L'ARMORSTAND ET UN ASSTRUC, QUI CONTIENT DES ASFRAMES

	PET_SNOWMAN(201, new ItemStack(Material.PUMPKIN), "§7Bonhomme de neige","§7Faites gaffe ,faudrait pas qu'il fonde",  1000,false,
			new ASStruc().setFrameRate(0).setSmall().setFrames(
					new ASFrame().setLocation(0, -0.5, 0).setHead(new ItemStack(Material.SNOW_BLOCK))
			),
			new ASStruc().setFrameRate(0).setSmall().setFrames(
					new ASFrame().setLocation(0, -0.1, 0).setHead(new ItemStack(Material.SNOW_BLOCK))
			),
			new ASStruc().setFrameRate(0).setSmall().setFrames(
					new ASFrame().setLocation(0, 0.35, 0).setHead(new ItemStack(Material.PUMPKIN))
			),
			new ASStruc().setFrameRate(4).setSmall().setFrames(
					new ASFrame().setRightArmPos( 300, 90, 0).setLeftArmPos( 300, 270, 0)
							.setRightArm(new ItemStack(Material.BLAZE_ROD)).setLeftArm(new ItemStack(Material.BLAZE_ROD)).setLocation(0, 0, 0),
					new ASFrame().setRightArmPos( 305, 90, 0).setLeftArmPos(305, 270, 0),
					new ASFrame().setRightArmPos( 310, 90, 0).setLeftArmPos(310, 270, 0),
					new ASFrame().setRightArmPos( 315, 90, 0).setLeftArmPos(315, 270, 0),
					new ASFrame().setRightArmPos( 320, 90, 0).setLeftArmPos(320, 270, 0),
					new ASFrame().setRightArmPos( 315, 90, 0).setLeftArmPos(315, 270, 0),
					new ASFrame().setRightArmPos( 310, 90, 0).setLeftArmPos(310, 270, 0),
					new ASFrame().setRightArmPos( 305, 90, 0).setLeftArmPos(310, 270, 0)
			)
	),

	PET_DOG(202, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:dog", "66381e813ef32aaaabcfe2a84f913a65691bb32b7d82dc2222dd58a5534c"), "§7Chien","§7Le meilleur amis de l'homme, aussi sur Entasia",  1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:dog", "66381e813ef32aaaabcfe2a84f913a65691bb32b7d82dc2222dd58a5534c").setHeadPos(0, 0, 0)
			)
	),

	PET_BEE(203, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:bee", "9394d758e04b4323e6e7ef3489fe4d0078c2efba8851c03a7deb6d4182c7ea3a"), "§7Abeille Robot","§7Une abeille terminator... Maintenant vous saurez qu'il faut se méfier",  1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -0.3, 0).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:bee", "9394d758e04b4323e6e7ef3489fe4d0078c2efba8851c03a7deb6d4182c7ea3a").setHeadPos(0, 0, 0)
			)
	),

	PET_ARIES(204, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:aries", "ec7864b99c63edc4d0d34a8eb6591742a8db6dafabe12b168554a368f97687cb"), "§7Bélier","§7Si c'est pas mignon ça ",  1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:aries", "ec7864b99c63edc4d0d34a8eb6591742a8db6dafabe12b168554a368f97687cb").setHeadPos(0, 0, 0)
			)
	),

	PET_EARTH(205, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:earth", "2e2cc42015e6678f8fd49ccc01fbf787f1ba2c32bcf559a015332fc5db50"), "§7Terre","§7Alors là, c'est le pied , la Terre te suis , c'est fou",  1000,false,
			new ASStruc().setFrameRate(7).setFrames(
					new ASFrame().setLocation(0, -0.3, 0).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:earth", "2e2cc42015e6678f8fd49ccc01fbf787f1ba2c32bcf559a015332fc5db50").setHeadPos(0, 0, 0),
					new ASFrame().setHeadPos(0, 22.5, 0),
					new ASFrame().setHeadPos(0, 45, 0),
					new ASFrame().setHeadPos(0, 67.5, 0)
			)
	),

	PET_PANDA(206, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:panda", "d8cdd4f285632c25d762ece25f4193b966c2641b15d9bdbc0a113023de76ab"), "§7Panda","§7Je ne suis ni noir ni blanc, je suis un panda",  1000,true,
			new ASStruc().setFrameRate(3).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:panda", "d8cdd4f285632c25d762ece25f4193b966c2641b15d9bdbc0a113023de76ab").setHeadPos(0, 0, 270),
					new ASFrame().setHeadPos(0, 22.5, 270),
					new ASFrame().setHeadPos(0, 45, 270),
					new ASFrame().setHeadPos(0, 67.5, 270),
					new ASFrame().setHeadPos(0, 90, 270),
					new ASFrame().setHeadPos(0, 112.5, 270),
					new ASFrame().setHeadPos(0, 125, 270),
					new ASFrame().setHeadPos(0, 147.5, 270),
					new ASFrame().setHeadPos(0, 45, 270),
					new ASFrame().setHeadPos(0, 170, 270),
					new ASFrame().setHeadPos(0, 192.5, 270),
					new ASFrame().setHeadPos(0, 215, 270),
					new ASFrame().setHeadPos(0, 237.5, 270),
					new ASFrame().setHeadPos(0, 260, 270),
					new ASFrame().setHeadPos(0, 282.5, 270),
					new ASFrame().setHeadPos(0, 305, 270),
					new ASFrame().setHeadPos(0, 327.5, 270),
					new ASFrame().setHeadPos(0, 350, 270)
			)
	),

	PET_COCHON_MINECART(207, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:cochon_mc", "369551dcc663c5db7c099ff9640b73e26d8f7c63ad5676b41d2614c2d380ce15"), "§7Cochon dans un wagon","§7Oh tien , un Poporc sauvage !", 1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:cochon_minecart","369551dcc663c5db7c099ff9640b73e26d8f7c63ad5676b41d2614c2d380ce15").setHeadPos(0, 0, 0)
			)
	),

	PET_RENARD(208, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:renard","fbdffe9642fc5280e68ce488e3bcf440687ed3bc566e315af824f428b6ff715"), "§7Renard","§7Rox et Rouky , amis pour la vie",  1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:renard","fbdffe9642fc5280e68ce488e3bcf440687ed3bc566e315af824f428b6ff715").setHeadPos(0, 0, 0)
			)
	),

	PET_SLIME(209, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3),
			"pet:slime","5accc1b1d40d70d8bf6f2136b86edd9d1595e3a07fa2ea97b73f9bc5e90ae3b5"), "§7Slime multicolore","§7J'aime les slimes , pas vous ?", 1000,false,
			new ASStruc().setFrameRate(0).setFrames(
					new ASFrame().setLocation(0, -1.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3),
							"pet:slime","5accc1b1d40d70d8bf6f2136b86edd9d1595e3a07fa2ea97b73f9bc5e90ae3b5").setHeadPos(0, 0, 0)
			)
	),

	PET_PINGUIN(210, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3), "pet:pinguin", "d3c57facbb3a4db7fd55b5c0dc7d19c19cb0813c748ccc9710c714727551f5b9"), "§7Pinguin","§7Qui n'a jamais rêvé d'avoir un petit pinguin qui se dandine ?", 1000,false,
			new ASStruc().setFrameRate(8).setSmall().setFrames(
					new ASFrame().setHeadPos(0,0,0).setLocation(0, -0.4, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:pinguin_body", "acea5e6a750c3ce1aa6c1419781f4f6971905d056e46cbe8797e70a528c0e08d"),
					new ASFrame().setHeadPos(0, 0, 5),
					new ASFrame().setHeadPos(0, 0, 0),
					new ASFrame().setHeadPos(0, 0, -5)


			),
			new ASStruc().setFrameRate(1).setSmall().setFrames(
					new ASFrame().setLocation(0, 0.02, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:pinguin_head", "d3c57facbb3a4db7fd55b5c0dc7d19c19cb0813c748ccc9710c714727551f5b9").setHeadPos(0, 0, 0)

			)
	),

	PET_BB8(211, PetsUtils.getSkull(new ItemStack(Material.SKULL_ITEM, 1, (short)3), "pet:bb8", "42d271f82674916dcb47b372a572f61e7472fe063b2c9246aeeb7c57a8835"), "§7BB8","§7Vient BB8 , on va botter les fesses de Snoke !", 1000,true,
			new ASStruc().setFrameRate(4).setFrames(
					new ASFrame().setHeadPos(0, 0, 270).setLocation(0.29, -1.1, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:bb8_body", "c856981ccec8a492898e0cb4d9443d21459d5b65dfa8da462d17697a178f8e"),
					new ASFrame().setHeadPos(0, 22.5, 270),
					new ASFrame().setHeadPos(0, 45, 270),
					new ASFrame().setHeadPos(0, 67.5, 270)
			),
			new ASStruc().setFrameRate(0).setSmall().setFrames(
					new ASFrame().setLocation(0, -0.05, -0.1).setHead(new ItemStack(Material.SKULL_ITEM,1, (short) 3), "pet:bb8_head", "42d271f82674916dcb47b372a572f61e7472fe063b2c9246aeeb7c57a8835").setHeadPos(0, 0, 0)

			)
	);





	public int id;
	public ItemStack itemStack;
	public String name;
	public int price;
	public String description;
	public boolean moveOnly;
	public ASStruc[] data;

	Pets(int id, ItemStack item, String name,String description, int price, boolean moveOnly, ASStruc... data){
		this.description= description;
		this.id = id;
		this.itemStack = item;
		this.name = name;
		ItemMeta meta = itemStack.getItemMeta();
		// TODO Pour la texture de la tête
		itemStack.setItemMeta(meta);
		this.price = price;
		this.moveOnly = moveOnly;
		this.data = data;
	}
}
