package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVetheanCannon extends ItemProjectileShooter {

    public ItemVetheanCannon(String name, int dam) {
    	super(name, dam, Sounds.blitz.getPrefixedName(), VetheaItems.acid, EntityResourceLocation.cannon.toString(), -1, 0);
        this.setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(damage + " Ranged Damage");
        list.add("Infinite Uses");
        list.add("Ammo: " + StatCollector.translateToLocal(VetheaItems.acid.getUnlocalizedName() + ".name"));
        list.add(Util.GREEN + "Vethean");
    }
}