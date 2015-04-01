package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemModAxe;
import net.divinerpg.api.items.ItemModPickaxe;
import net.divinerpg.api.items.ItemModShovel;
import net.divinerpg.api.items.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class TwilightItemsTools {

	public static Item edenShickaxe;
	public static Item wildwoodShickaxe;
	public static Item apalachiaShickaxe;
	public static Item skythernShickaxe;
	public static Item mortumShickaxe;

	public static Item edenPickaxe;
	public static Item wildwoodPickaxe;
	public static Item apalachiaPickaxe;
	public static Item skythernPickaxe;
	public static Item mortumPickaxe;

	public static Item edenAxe;
	public static Item wildwoodAxe;
	public static Item apalachiaAxe;
	public static Item skythernAxe;
	public static Item mortumAxe;

	public static Item edenShovel;
	public static Item wildwoodShovel;
	public static Item apalachiaShovel;
	public static Item skythernShovel;
	public static Item mortumShovel;
	
	public static void init() {
		edenShickaxe       = new ItemShickaxe(ToolMaterialMod.EdenShick, "edenShickaxe");
	    wildwoodShickaxe   = new ItemShickaxe(ToolMaterialMod.WildwoodShick, "wildwoodShickaxe");
	    apalachiaShickaxe  = new ItemShickaxe(ToolMaterialMod.ApalachiaShick, "apalachiaShickaxe");
	    skythernShickaxe   = new ItemShickaxe(ToolMaterialMod.SkythernShick, "skythernShickaxe");
	    mortumShickaxe     = new ItemShickaxe(ToolMaterialMod.MortumShick, "mortumShickaxe");

	    edenPickaxe        = new ItemModPickaxe(ToolMaterialMod.EdenPick, "edenPickaxe");
	    wildwoodPickaxe    = new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwoodPickaxe");
	    apalachiaPickaxe   = new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachiaPickaxe");
	    skythernPickaxe    = new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythernPickaxe");
	    mortumPickaxe      = new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortumPickaxe");

	    edenAxe            = new ItemModAxe(ToolMaterialMod.EdenAxe, "edenAxe");
	    wildwoodAxe        = new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwoodAxe");
	    apalachiaAxe       = new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachiaAxe");
	    skythernAxe        = new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythernAxe");
	    mortumAxe          = new ItemModAxe(ToolMaterialMod.MortumAxe, "mortumAxe");

	    edenShovel         = new ItemModShovel(ToolMaterialMod.EdenSpade, "edenShovel");
	    wildwoodShovel     = new ItemModShovel(ToolMaterialMod.WildwoodSpade, "wildwoodShovel");
	    apalachiaShovel    = new ItemModShovel(ToolMaterialMod.ApalachiaSpade, "apalachiaShovel");
	    skythernShovel     = new ItemModShovel(ToolMaterialMod.SkythernSpade, "skythernShovel");
	    mortumShovel       = new ItemModShovel(ToolMaterialMod.MortumSpade, "mortumShovel");
	}

}
