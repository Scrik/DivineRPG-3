package net.divinerpg.items.arcana;

import net.divinerpg.api.items.ItemModSeeds;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.Block;

public class ItemArcanaSeeds extends ItemModSeeds{

	public ItemArcanaSeeds(String name, Block block) {
		super(name, block, ArcanaBlocks.arcanaGrass);
	}

}
