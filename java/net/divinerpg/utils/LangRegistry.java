package net.divinerpg.utils;

import java.util.ArrayList;

import net.divinerpg.blocks.vanilla.IDivineMetaBlock;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LangRegistry extends RegistryFile {

    private static ArrayList<Block> blocks = new ArrayList<Block>();
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Item> key = new ArrayList<Item>();
    private static ArrayList<DivineRPGTabs> tabs = new ArrayList<DivineRPGTabs>();
    private static ArrayList<String> mobs = new ArrayList<String>();

    public static final RegistryFile instance = new LangRegistry();

    public LangRegistry() {
        super("en_US.lang");
    }

    public static void registerNames() {
        instance.addNames();
    }

    public static void addAchievements() {
        instance.addToFile("achievement.divineIntervention.desc=Spawn The Watcher");
        instance.addToFile("achievement.possibilities.desc=Enter the Eden dimension");
        instance.addToFile("achievement.friendOrFoe.desc=Kill a bunny");
        instance.addToFile("achievement.darkAnotherDay.desc=Enter the Mortum Dimension");
        instance.addToFile("achievement.whenPigsFly.desc=Wear a full Angelic armor set");
        instance.addToFile("achievement.offKey.desc=Shoot a Sound of Music");
        instance.addToFile("achievement.enrichment.desc=");
        instance.addToFile("achievement.littleCreature.desc=Spawn a Golem Of Rejuv'");
        instance.addToFile("achievement.halloweenSpirit.desc=Trade with a Jack-O-Man");
        instance.addToFile("achievement.feedingOnTheFish.desc=Kill a Shark");
        instance.addToFile("achievement.frozenLand.desc=Enter the Iceika dimension");
        instance.addToFile("achievement.frozenGoods.desc=Open a frozen chest");
        instance.addToFile("achievement.lilTinkerin.desc=Trade with a Tinkerer");
        instance.addToFile("achievement.lilGift.desc=Open a gift Box");
        instance.addToFile("achievement.divinePlan.desc=Craft a Divine Sword");
        instance.addToFile("achievement.whatLiesWithin.desc=Enter The Dungeon Of Arcana");
        instance.addToFile("achievement.perfectlyCorrupted.desc=Use the Altar Of Corruption");
        instance.addToFile("achievement.totalDemonization.desc=Use the Demon Furnace");
        instance.addToFile("achievement.evilDisease.desc=Kill Parasecta");
        instance.addToFile("achievement.dungeonMaster.desc=Kill Dramix");
        instance.addToFile("achievement.eyeOfEvil.desc=Look into the eye of The Eye");
        instance.addToFile("achievement.tripleDanger.desc=Kill an Ender Triplet");
        instance.addToFile("achievement.hotterThanHell.desc=Step on a Heat Trap in Arcana");
        instance.addToFile("achievement.mealToRemember.desc=Eat a chicken dinner");
        instance.addToFile("achievement.yuk.desc=Use an Arcana potion");
        instance.addToFile("achievement.spawnDAR.desc=Spawn Densos and Reyvor");
        instance.addToFile("achievement.dramcryxDeath.desc=Kill a Jungle Dramcryx");
        instance.addToFile("achievement.allHellLoose.desc=Use a Storm Sword");
        instance.addToFile("achievement.skyHigh.desc=Jump on an Elevantium Block");
        instance.addToFile("achievement.oneLampTwoLampRedLampBlueLamp.desc=Craft an Eden Lamp");
        
        instance.addToFile("achievement.divineIntervention=Divine Intervention");
        instance.addToFile("achievement.possibilities=Possibilities");
        instance.addToFile("achievement.friendOrFoe=Friend or Foe?");
        instance.addToFile("achievement.darkAnotherDay=Dark Another Day");
        instance.addToFile("achievement.whenPigsFly=When Pigs Fly");
        instance.addToFile("achievement.offKey=Off Key");
        instance.addToFile("achievement.enrichment=Enrichment");
        instance.addToFile("achievement.littleCreature=Little Creature");
        instance.addToFile("achievement.halloweenSpirit=Halloween Spirit");
        instance.addToFile("achievement.oneLamp=One Lamp");
        instance.addToFile("achievement.feedingOnTheFish=Feeding on the Fish");
        instance.addToFile("achievement.hotterThanHell=Hotter than Hell");
        instance.addToFile("achievement.mealToRemember=Meal to Remember");
        instance.addToFile("achievement.yuk=Yuk!");
        instance.addToFile("achievement.frozenLand=Frozen Land");
        instance.addToFile("achievement.frozenGoods=Frozen Goods");
        instance.addToFile("achievement.lilTinkerin=Lil' Tinkerin");
        instance.addToFile("achievement.divinePlan=Divine Plan");
        instance.addToFile("achievement.whatLiesWithin=What Lies Within");
        instance.addToFile("achievement.perfectlyCorrupted=Perfectly Corrupted");
        instance.addToFile("achievement.totalDemonization=Total Demonization");
        instance.addToFile("achievement.evilDisease=Evil Disease");
        instance.addToFile("achievement.dungeonMaster=Dungeon Master");
        instance.addToFile("achievement.eyeOfEvil=Eye of Evil");
        instance.addToFile("achievement.tripleDanger=Triple Danger");
        instance.addToFile("achievement.lilGift=Lil' Gift");
        instance.addToFile("achievement.spawnDAR=Ten Heads are Better than One");
        instance.addToFile("achievement.dramcryxDeath=Death to all Jungle Stegosaurous!");
        instance.addToFile("achievement.allHellLoose=All Hell Loose");
        instance.addToFile("achievement.skyHigh=Sky High");
        instance.addToFile("achievement.oneLampTwoLampRedLampBlueLamp=One Lamp Two Lamp Red Lamp Blue Lamp");
    }

    public static void addMob(String name) {
        mobs.add(name);
    }

    public static void addBlock(Block block) {
        blocks.add(block);
    }

    public static void addItem(Item item) {
        items.add(item);
    }

    public static void addKeyItem(Item item) {
        key.add(item);
    }

    public static void addTab(DivineRPGTabs tab) {
        tabs.add(tab);
    }

    @Override
    public void addNames() {
        addTabNames();
        for (Block block : blocks)
        	if(!(block instanceof IDivineMetaBlock))localizeName("tile", block.getUnlocalizedName());
        	else ((IDivineMetaBlock)block).addNames();
        for (Item item : items)
            localizeName("item", item.getUnlocalizedName());
        addKeyItemNames();
        addMobNames();
        addAchievements();
        instance.write();
    }

    public static void addMobNames() {
        for (int i = 0; i < mobs.size(); i++) {
            String mob = mobs.get(i);
            instance.addToFile("entity.divinerpg." + mob + ".name=" + getLocalizedMobName(mob));
            instance.addToFile("entity." + mob + ".name=" + getLocalizedMobName(mob));
        }
    }

    public static void addKeyItemNames() {
        for (int k = 0; k < key.size(); k++) {
            Item item = key.get(k);
            String name = item.getUnlocalizedName().substring(5);
            String finalName = "Key";
            instance.addToFile("item." + name + ".name=" + finalName, name);
        }
    }

    public static void addTabNames() {
        for (int i = 0; i < tabs.size(); i++) {
            String label = tabs.get(i).getTabLabel();
            String name = tabs.get(i).getName();
            instance.addToFile("itemGroup." + label + "=DivineRPG: " + name, label);
        }
    }

}
