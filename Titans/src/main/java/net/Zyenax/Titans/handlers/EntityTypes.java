package net.Zyenax.Titans.handlers;

import java.util.Map;

import net.Zyenax.Titans.utils.Utils;
import net.minecraft.server.v1_11_R1.Entity;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

public enum EntityTypes
{
    //NAME("Entity name", Entity ID, yourcustomclass.class);
    TITAN("Titan", 60, Titan.class); //You can add as many as you want.

    private EntityTypes(String name, int id, Class<? extends Entity> custom)
    {
        addToMaps(custom, name, id);
    }

  public static void spawnEntity(Entity entity, Location loc)
   {
     entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
     ((CraftWorld)loc.getWorld()).getHandle().addEntity(entity);
   }

    @SuppressWarnings("unchecked")
	private static void addToMaps(Class<? extends Entity> clazz, String name, int id)
    {
        //getPrivateField is the method from above.
        //Remove the lines with // in front of them if you want to override default entities (You'd have to remove the default entity from the map first though).
        ((Map<String, Class<? extends Entity>>)Utils.getPrivateField("c", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(name, clazz);
        ((Map<Class<? extends Entity>, String>)Utils.getPrivateField("d", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(clazz, name);
        //((Map)getPrivateField("e", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(Integer.valueOf(id), clazz);
        ((Map<Class<? extends Entity>, Integer>)Utils.getPrivateField("f", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(clazz, Integer.valueOf(id));
        //((Map)getPrivateField("g", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(name, Integer.valueOf(id));
    }
}
