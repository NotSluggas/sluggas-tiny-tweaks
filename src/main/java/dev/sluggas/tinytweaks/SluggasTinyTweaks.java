package dev.sluggas.tinytweaks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SluggasTinyTweaks implements ModInitializer {
	public static final String MOD_ID = "sluggas_tiny_tweaks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Successfully Loaded Mod");

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS),
				GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("sluggas_tiny_tweaks", "end_shard_ore_small"))
		);
	}
}