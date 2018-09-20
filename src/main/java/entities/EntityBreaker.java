package entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBreaker extends EntityMob {
	
	public byte breakProgress;
	
	public EntityBreaker(World worldIn) {
		super(worldIn);
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        tasks.addTask(7, new EntityAIWander(this, 1.0D));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(8, new EntityAILookIdle(this));
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
		if(!worldObj.isRemote && breakProgress >= 60){
			Vec3 v1 = getPositionVector();
			Entity target = getAttackTarget();
			if(target != null){
				Vec3 v2 = target.getPositionVector();
				MovingObjectPosition mop = worldObj.rayTraceBlocks(v1, v2);
				if(mop != null){
					BlockPos pos = mop.getBlockPos();
					if(pos != null){
						worldObj.setBlockState(pos, Blocks.air.getDefaultState());
						breakProgress = 0;
					}
				}
			}
		}
		else if(!worldObj.isRemote)
			++breakProgress;
	}
}
