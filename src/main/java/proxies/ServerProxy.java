package proxies;

import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy extends Proxy {

	@Override
	public Side side() {
		return Side.SERVER;
	}

	@Override
	public boolean getKeyDown(String key) {
		return false;
	}

	@Override
	public void render() {}

}
