package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.projectile.EntityLamona;
import net.divinerpg.entities.iceika.projectile.EntitySnowflakeShuriken;
import net.divinerpg.entities.twilight.projectile.EntitySlicerApalachia;
import net.divinerpg.entities.twilight.projectile.EntitySlicerEden;
import net.divinerpg.entities.twilight.projectile.EntitySlicerHalite;
import net.divinerpg.entities.twilight.projectile.EntitySlicerMortum;
import net.divinerpg.entities.twilight.projectile.EntitySlicerSkythern;
import net.divinerpg.entities.twilight.projectile.EntitySlicerWildwood;
import net.divinerpg.entities.vanilla.projectile.EntityShuriken;
import net.divinerpg.entities.vanilla.projectile.EntityVileStorm;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemThrowable extends ItemMod {

	private int damage;

	public ItemThrowable(int damage, String name) {
		super(name);
		this.damage = damage;
		setCreativeTab(DivineRPGTabs.ranged);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if (!var3.capabilities.isCreativeMode) 
			--var1.stackSize;
		
		if(!var2.isRemote){
			var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if(var1.getItem() == VanillaItemsWeapons.shuriken){
				var2.spawnEntityInWorld(new EntityShuriken(var2, var3));
			}
			
			if(var1.getItem() == IceikaItems.snowflakeShuriken){
				var2.spawnEntityInWorld(new EntitySnowflakeShuriken(var2, var3));
			}

			if(var1.getItem() == VanillaItemsWeapons.vileStorm){
				var2.spawnEntityInWorld(new EntityVileStorm(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.edenSlicer){
				var2.spawnEntityInWorld(new EntitySlicerEden(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.wildwoodSlicer){
				var2.spawnEntityInWorld(new EntitySlicerWildwood(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.apalachiaSlicer){
				var2.spawnEntityInWorld(new EntitySlicerApalachia(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.skythernSlicer){
				var2.spawnEntityInWorld(new EntitySlicerSkythern(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.mortumSlicer){
				var2.spawnEntityInWorld(new EntitySlicerMortum(var2, var3));
			}

			if(var1.getItem() == TwilightItemsWeapons.haliteSlicer){
				var2.spawnEntityInWorld(new EntitySlicerHalite(var2, var3));
			}
			
			if(var1.getItem() == ArcanaItems.lamona){
				var2.spawnEntityInWorld(new EntityLamona(var2, var3));
			}
		}
		return var1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(var1.getItem() != ArcanaItems.lamona)
			par3List.add(damage + " Ranged Damage");
		else
			par3List.add("Casts light when thrown");	
		if(var1.getItem() == VanillaItemsWeapons.vileStorm) {
			par3List.add("Poison Damage");
		}
	}
}
