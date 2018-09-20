package main;

import items.HardcoreItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class HardcoreEventHandler {
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		if(WorldData.isMinion(event.player)){
			ItemStack[] armor = event.player.inventory.armorInventory;
			if(armor[3] != null && armor[3].getItem() != HardcoreItems.mushroomHelmet){
				event.player.inventory.addItemStackToInventory(armor[3]);
				event.player.setCurrentItemOrArmor(4, null);
			}
			if(armor[1] != null){
				event.player.inventory.addItemStackToInventory(armor[1]);
				event.player.setCurrentItemOrArmor(2, null);
			}
			if(armor[2] != null){
				event.player.inventory.addItemStackToInventory(armor[2]);
				event.player.setCurrentItemOrArmor(3, null);
			}
			if(armor[0] != null){
				event.player.inventory.addItemStackToInventory(armor[0]);
				event.player.setCurrentItemOrArmor(1, null);
			}
		}
	}
}
