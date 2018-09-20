package proxies;

import items.HardcoreItems;
import main.HardcoreMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends Proxy {

	@Override
	public Side side() {
		return Side.CLIENT;
	}

	@Override
	public boolean getKeyDown(String key) {
		GameSettings settings = Minecraft.getMinecraft().gameSettings;
		if(key.matches("jump"))
			return settings.keyBindJump.isKeyDown();
		return false;
	}

	@Override
	public void render() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(HardcoreItems.mushroomHelmet, 0, new ModelResourceLocation(HardcoreMod.modId + ":mushroomhelmet"));
	}

}
