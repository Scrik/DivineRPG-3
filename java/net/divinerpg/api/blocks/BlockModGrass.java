package net.divinerpg.api.blocks;

import java.util.Random;

import net.divinerpg.items.arcana.ItemArcanaSeeds;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModGrass extends BlockMod {

    protected IIcon top;
    protected IIcon bottom;
    protected IIcon side;
    protected BlockMod dirt;
    protected String dirtName;

    public BlockModGrass(BlockMod dirt, String name, String dirtName, float hardness) {
        super(EnumBlockType.GRASS, name, hardness);
        this.dirt = dirt;
        this.textureName = Reference.PREFIX + name;
        this.dirtName = Reference.PREFIX + dirtName;
        setBlockTextureName(textureName);
        setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int intSide, int meta) {
        return intSide == 1 ? top : (intSide == 0 ? bottom : side);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        side = icon.registerIcon(textureName + "_side");
        top = icon.registerIcon(textureName + "_top");
        bottom = icon.registerIcon(dirtName);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) world.setBlock(x, y, z, dirt);
            else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
                for (int l = 0; l < 4; ++l) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    if(world.getBlock(i1, j1, k1) == dirt && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                        world.setBlock(i1, j1, k1, this);
                }
            }
        }
    }


    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        if(this == ArcanaBlocks.arcanaGrass && plantable instanceof ItemArcanaSeeds) return true;
        return false;
    }
}
