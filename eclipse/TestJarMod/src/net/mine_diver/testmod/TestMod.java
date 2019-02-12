package net.mine_diver.testmod;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.modificationstation.stationloader.common.util.Mod;
import net.modificationstation.stationloader.common.util.Mod.*;
import net.modificationstation.stationloader.events.common.mods.SLPostInitializationEvent;

@Mod(name = "Test Mod", modid = "tstmd")
public class TestMod {
    @Instance
    public static TestMod INSTANCE;
	@EventHandler
	public void postInit(SLPostInitializationEvent event) {
        CraftingManager.getInstance().addRecipe(new ItemStack(Item.diamond), new Object[] {"#", Character.valueOf('#'), Block.dirt});
	}
}
