package items;

import proxies.Proxy;
import main.HardcoreMod;
import models.ModelMushroomHelmet;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMushroomHelmet extends ItemArmor implements ISpecialArmor{
	
	public ItemMushroomHelmet(){
		super(ArmorMaterial.LEATHER, 0, 0);
		setUnlocalizedName("mushroomhelmet");
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		return HardcoreMod.modId + ":textures/armor/mushroomhelmet.png";
	}
	
	@SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        return new ModelMushroomHelmet();
    }
	
	@Override
	public boolean isValidArmor(ItemStack stack, int slot, Entity entity){
		return slot == 0;
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(Proxy.isKeyDown("jump"))
			player.motionY += 0.15;
		player.jumpMovementFactor = 0.05F;
		player.fallDistance = 0;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {}
}
