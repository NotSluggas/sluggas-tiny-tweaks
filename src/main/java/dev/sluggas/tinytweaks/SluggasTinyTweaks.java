package dev.sluggas.tinytweaks;

import net.fabricmc.api.ModInitializer;
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
	}
}