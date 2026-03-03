package dev.sluggas.tinytweaks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SluggasTinyTweaks.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SluggasTinyTweaks.MOD_ID, name));
    }

    // End Shard Ore
    public static final Block END_SHARD_ORE = new Block(AbstractBlock.Settings.create()
            .registryKey(keyOfBlock("end_shard_ore"))
            .strength(3.4f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));

    // End Shard Cluster
    public static final Block END_SHARD_CLUSTER = new Block(AbstractBlock.Settings.create()
            .registryKey(keyOfBlock("end_shard_cluster"))
            .strength(3.5f) // slightly stronger since it's condensed
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK));

    private static void registerBlock(String name, Block block) {
        Identifier id = Identifier.of(SluggasTinyTweaks.MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);

        Registry.register(Registries.BLOCK, blockKey, block);

        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, new Item.Settings()
                .registryKey(itemKey)
                .useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {

        registerBlock("end_shard_ore", END_SHARD_ORE);
        registerBlock("end_shard_cluster", END_SHARD_CLUSTER);

// add to creative inv
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.END_STONE, END_SHARD_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.LAPIS_BLOCK, END_SHARD_CLUSTER);
        });
    }
}