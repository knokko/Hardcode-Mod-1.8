package entities;

import main.HardcoreMod;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityHandler {
	
	public static void registerMonster(Class entityClass, String name){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, 494999444, 333333333));
		EntityRegistry.addSpawn(entityClass, 25, 3, 5, EnumCreatureType.MONSTER, BiomeGenBase.plains);
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, HardcoreMod.modInstance, 64, 1, true);
	}
	
	public static void init(){
		registerMonster(EntityBreaker.class, "Breaker");
	}
}
