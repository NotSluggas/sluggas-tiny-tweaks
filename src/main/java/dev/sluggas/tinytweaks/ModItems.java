package dev.sluggas.tinytweaks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item END_SHARD = registerItem("end_shard", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SluggasTinyTweaks.MOD_ID, "end_shard")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SluggasTinyTweaks.MOD_ID, name)),
                item);
    }

    public static void registerModItems() {
        //add to Creative inv
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.ANCIENT_DEBRIS, END_SHARD);
        });

    }
}