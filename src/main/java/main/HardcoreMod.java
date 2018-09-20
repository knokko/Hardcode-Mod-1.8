package main;

import commands.CommandMinion;
import entities.EntityHandler;
import proxies.Proxy;
import items.HardcoreItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = HardcoreMod.modId, name = HardcoreMod.name, version = HardcoreMod.version)
public class HardcoreMod {
	
	public static final String modId = "hardcore";
	public static final String name = "Hardcore";
	public static final String version = "1.8-1.0";
	
	@Instance(modId)
	public static HardcoreMod modInstance;
	
	@SidedProxy(clientSide = "proxies.ClientProxy", serverSide = "proxies.ServerProxy")
	public static Proxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		HardcoreItems.register();
		FMLCommonHandler.instance().bus().register(new HardcoreEventHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.render();
		EntityHandler.init();
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandMinion());
	}
	
}
