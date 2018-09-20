package items;

import proxies.Proxy;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class HardcoreItems {
	
	public static final ItemMushroomHelmet mushroomHelmet = new ItemMushroomHelmet();
	
	public static final void register(){
		GameRegistry.registerItem(mushroomHelmet, "mushroom_helmet");
	}
}
