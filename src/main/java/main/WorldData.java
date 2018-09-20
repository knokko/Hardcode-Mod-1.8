package main;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class WorldData extends WorldSavedData {
	
	public NBTTagCompound minionIds = new NBTTagCompound();
	
	public WorldData() {
		super("hardcore");
	}
	
	public WorldData(String id){
		super(id);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		minionIds = nbt.getCompoundTag("minions");
		System.out.println("readFromNBT: minionIds: " + nbt.getCompoundTag("minions"));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setTag("minions", minionIds);
		System.out.println("writeToNBT: nbt.getCompoundTag: " + nbt.getCompoundTag("minions"));
	}
	
	public static WorldData instance(World world){
		WorldData data = (WorldData) world.loadItemData(WorldData.class, "hardcore");
		if(data == null){
			data = new WorldData();
			world.setItemData("hardcore", data);
		}
		return data;
	}
	
	public static WorldData instance(Entity entity){
		return entity != null ? instance(entity.worldObj) : null;
	}
	
	public static boolean isMinion(Entity entity){
		return entity != null ? instance(entity).minionIds.getBoolean(entity.getUniqueID().toString()) : false;
	}
	
	public static void addMinion(Entity entity){
		if(entity != null){
			instance(entity).minionIds.setBoolean(entity.getUniqueID().toString(), true);
			instance(entity).markDirty();
		}
	}
}
