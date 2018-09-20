package proxies;

import main.HardcoreMod;
import net.minecraftforge.fml.relauncher.Side;

public abstract class Proxy {
	
	public abstract Side side();
	public abstract boolean getKeyDown(String key);
	public abstract void render();
	
	public static final boolean isKeyDown(String key){
		return HardcoreMod.proxy.getKeyDown(key);
	}
	
	public static final Side getSide(){
		return HardcoreMod.proxy.side();
	}
}
