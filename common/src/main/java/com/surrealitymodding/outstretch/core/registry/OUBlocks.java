package com.surrealitymodding.outstretch.core.registry;

import com.surrealitymodding.outstretch.common.item.FollowItemLike;
import com.surrealitymodding.outstretch.core.registry.util.Stoneset;
import com.surrealitymodding.outstretch.core.Outstretch;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class OUBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Outstretch.MOD_ID);

    // Seashale
    private static final Stoneset SEASHALE_SET = new Stoneset(MaterialColor.COLOR_CYAN, MaterialColor.TERRACOTTA_BLUE);

    public static final Supplier<Block> SEASHALE = registerBlock("seashale", SEASHALE_SET::rotatedPillarBlock, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.DEEPSLATE);
    public static final Supplier<Block> SEASHALE_FURNACE = registerBlock("seashale_furnace", SEASHALE_SET::furnaceBlock, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.DEEPSLATE);






    private static Supplier<Block> registerBlock(String id, Supplier<Block> block, CreativeModeTab tab, Block followBlock) {
        Supplier<Block> register = BLOCKS.register(id, block);
        OUItems.ITEMS.register(id, () -> new FollowItemLike(register.get(), new Item.Properties(), tab, followBlock));
        return register;
    }
}


