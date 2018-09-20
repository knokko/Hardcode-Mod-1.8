package commands;

import items.HardcoreItems;
import main.WorldData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandMinion extends CommandBase {

	public CommandMinion() {
	}

	@Override
	public String getName() {
		return "minion";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/minion (armor)";
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof Entity){
			if(args.length == 0){
				WorldData.addMinion((Entity) sender);
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You are now a minion."));
			}
			else if(args.length == 1){
				if(args[0].matches("armor"))
					((Entity)sender).setCurrentItemOrArmor(4, new ItemStack(HardcoreItems.mushroomHelmet));
			}
		}
		else
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Only enities can become a minion."));
	}

}
