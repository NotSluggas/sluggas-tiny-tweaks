package dev.sluggas.tinytweaks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
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

    public static final Item GRILLED_CARROT = registerItem("grilled_carrot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SluggasTinyTweaks.MOD_ID, "grilled_carrot")))
            .food(new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SluggasTinyTweaks.MOD_ID, name)),
                item);
    }

    public static void registerModItems() {
// Add to creative inv
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.ANCIENT_DEBRIS, END_SHARD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.CARROT, GRILLED_CARROT);
        });

    }
}