package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMusicShooter extends ItemMod {
	
	public ItemMusicShooter(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(4000);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			if (this == IceikaItems.soundOfCarols) {
				world.spawnEntityInWorld(new EntityCarol(world, player));
				world.playSoundAtEntity(player, Sounds.soundOfCarols.getPrefixedName(), 1, 1);
			} else {
				world.spawnEntityInWorld(new EntityMusic(world, player));
				world.playSoundAtEntity(player, Sounds.soundOfMusic.getPrefixedName(), 1, 1);
			}
			stack.damageItem(1, player);	
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(this == IceikaItems.soundOfCarols) {
			par3List.add("16 Ranged damage");
		} else {
			par3List.add("10 Ranged damage");
		}
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses remaining");
	}
}