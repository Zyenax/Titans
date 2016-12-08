package net.Zyenax.Titans.handlers;

import net.Zyenax.Titans.utils.Utils;
import net.minecraft.server.v1_11_R1.*;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

import java.util.HashSet;

public class Titan extends EntityIronGolem {

    public Titan(org.bukkit.World world) {
        super(((CraftWorld) world).getHandle());
        HashSet<?> goalB = (HashSet<?>) Utils.getPrivateField("b", PathfinderGoalSelector.class, goalSelector);
        goalB.clear();
        HashSet<?> goalC = (HashSet<?>) Utils.getPrivateField("c", PathfinderGoalSelector.class, goalSelector);
        goalC.clear();
        HashSet<?> targetB = (HashSet<?>) Utils.getPrivateField("b", PathfinderGoalSelector.class, targetSelector);
        targetB.clear();
        HashSet<?> targetC = (HashSet<?>) Utils.getPrivateField("c", PathfinderGoalSelector.class, targetSelector);
        targetC.clear();
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0D, false));
        this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0D, true));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntitySpider>(this, EntitySpider.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityIronGolem>(this, EntityIronGolem.class, false));
    }

}
