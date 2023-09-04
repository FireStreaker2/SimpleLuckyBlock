package firestreaker2.simple.lucky.block;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class SimpleLuckyBlock implements ModInitializer {
  // This logger is used to write text to the console and the log file.
  // It is considered best practice to use your mod id as the logger's name.
  // That way, it's clear which mod wrote info, warnings, and errors.

  // public static final Item SIMPLE_LUCKY_BLOCK_ITEM = new Item(new Item.Settings());
  public static final Block SIMPLE_LUCKY_BLOCK = new Block(FabricBlockSettings.create().strength(4.0f, 1200.0f).sounds(BlockSoundGroup.STONE));



  @Override
  public void onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    // Registry.register(Registries.ITEM, new Identifier("simpleluckyblock", "simple_lucky_block"), SIMPLE_LUCKY_BLOCK_ITEM);
    Registry.register(Registries.BLOCK, new Identifier("simpleluckyblock", "simple_lucky_block"), SIMPLE_LUCKY_BLOCK);
    Registry.register(Registries.ITEM, new Identifier("simpleluckyblock", "simple_lucky_block"), new BlockItem(SIMPLE_LUCKY_BLOCK, new Item.Settings()));

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
      content.add(SIMPLE_LUCKY_BLOCK);
    });

  }
}