package fr.entasia.cosmetiques.versions;

import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.EntityLiving;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.PathfinderGoal;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class v1_12_R1 implements IPathFinder {

	public static class EntasiaPath extends PathfinderGoal {


		private EntityInsentient entity;
		private EntityPlayer owner;
		private double speed;
		private float distanceSquared;

		public EntasiaPath(EntityInsentient entity, EntityPlayer owner, double speed, float distance) {
			this.entity = entity;
			this.owner = owner;
			this.speed = speed;
			this.distanceSquared = distance * distance;
			this.a(3);
		}

		@Override
		public boolean a() {
			return (owner != null && owner.isAlive() && this.entity.h(owner) > (double) distanceSquared);
		}

		@Override
		public void d() {
			this.entity.getNavigation().o();
		}

		@Override
		public void e() {
			this.entity.getNavigation().a(owner, this.speed);
		}
	}

	@Override
	public void setPathGoal(LivingEntity ent, Player p) {

		EntityLiving entityLiving = ((CraftLivingEntity)ent).getHandle();
		if (entityLiving instanceof EntityInsentient) {
			EntityPlayer entityPlayer = ((CraftPlayer)p).getHandle();
			EntityInsentient entityInsentient = (EntityInsentient)entityLiving;
			entityInsentient.goalSelector.a(1, new EntasiaPath(entityInsentient, entityPlayer, 1.5D, 2.0F));
		} else {
			throw new IllegalArgumentException(entityLiving.getClass().getSimpleName() + " is not an instance of an EntityInsentient.");
		}
	}
}
