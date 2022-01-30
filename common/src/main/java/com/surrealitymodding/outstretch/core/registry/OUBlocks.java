package com.surrealitymodding.outstretch.core.registry;

import com.surrealitymodding.outstretch.common.block.entity.OutstretchFurnaceBlockEntity;
import com.surrealitymodding.outstretch.common.item.FollowItemLike;
import com.surrealitymodding.outstretch.core.registry.util.Stoneset;
import com.surrealitymodding.outstretch.core.Outstretch;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class OUBlocks {
    public static final PollinatedRegistry<Block> BLOCKS = PollinatedRegistry.create(Registry.BLOCK, Outstretch.MOD_ID);
    public static final PollinatedRegistry<BlockEntityType<?>> BLOCK_ENTITIES = PollinatedRegistry.create(Registry.BLOCK_ENTITY_TYPE, Outstretch.MOD_ID);

    /* Seashale Set */
    private static final Stoneset SEASHALE_SET = new Stoneset(MaterialColor.COLOR_CYAN, MaterialColor.TERRACOTTA_BLUE);

    public static final Supplier<Block> SEASHALE = registerBlock("seashale", SEASHALE_SET::rotatedPillarBlock, CreativeModeTab.TAB_BUILDING_BLOCKS, Blocks.DEEPSLATE);
    public static final Supplier<Block> SEASHALE_FURNACE = registerBlock("seashale_furnace", SEASHALE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.DEEPSLATE);

    // Andesite Set
    private static final Stoneset ANDESITE_SET = new Stoneset(MaterialColor.COLOR_CYAN, MaterialColor.TERRACOTTA_BLUE);
    public static final Supplier<Block> ANDESITE_FURNACE = registerBlock("andesite_furnace", ANDESITE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.ANDESITE);

    // Diorite Set
    private static final Stoneset DIORITE_SET = new Stoneset(MaterialColor.STONE, MaterialColor.TERRACOTTA_WHITE);
    public static final Supplier<Block> DIORITE_FURNACE = registerBlock("diorite_furnace", DIORITE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.DIORITE);

    //Granite Set
    private static final Stoneset GRANITE_SET = new Stoneset(MaterialColor.COLOR_ORANGE, MaterialColor.STONE);
    public static final Supplier<Block> GRANITE_FURNACE = registerBlock("granite_furnace", GRANITE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.GRANITE);

    //Tuff Set
    private static final Stoneset TUFF_SET = new Stoneset(MaterialColor.COLOR_GRAY, MaterialColor.STONE);
    public static final Supplier<Block> TUFF_FURNACE = registerBlock("tuff_furnace", TUFF_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.TUFF);

    //Dripstone Set
    private static final Stoneset DRIPSTONE_SET = new Stoneset(MaterialColor.COLOR_RED, MaterialColor.STONE);
    public static final Supplier<Block> DRIPSTONE_FURNACE = registerBlock("dripstone_furnace", DRIPSTONE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.DRIPSTONE_BLOCK);

    //Sandstone Set
    private static final Stoneset SANDSTONE_SET = new Stoneset(MaterialColor.SAND, MaterialColor.STONE);
    public static final Supplier<Block> SANDSTONE_FURNACE = registerBlock("sandstone_furnace", SANDSTONE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.SANDSTONE);

    //Red Sandstone Set
    private static final Stoneset RED_SANDSTONE_SET = new Stoneset(MaterialColor.SAND, MaterialColor.COLOR_ORANGE);
    public static final Supplier<Block> RED_SANDSTONE_FURNACE = registerBlock("red_sandstone_furnace", RED_SANDSTONE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.RED_SANDSTONE);

    //Netherrack Set
    private static final Stoneset NETHERRACK_SET = new Stoneset(MaterialColor.COLOR_RED, MaterialColor.STONE);
    public static final Supplier<Block> NETHERRACK_FURNACE = registerBlock("netherrack_furnace", NETHERRACK_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.NETHERRACK);

    //Endstone Set
    private static final Stoneset END_STONE_SET = new Stoneset(MaterialColor.STONE, MaterialColor.COLOR_YELLOW);
    public static final Supplier<Block> END_STONE_FURNACE = registerBlock("end_stone_furnace", END_STONE_SET::furnaceBlock, CreativeModeTab.TAB_DECORATIONS, Blocks.END_STONE);

    //TODO: Haunted to add more to this just do this ---------------------------------------------------------------------------------------------------------------------------------------------------------------------v
    //     public static final Supplier<BlockEntityType<OUFurnaceBlockEntity>> OUTSTRETCH_FURNACE_BE = BLOCK_ENTITIES.register("outstretch_furnace", () -> BlockEntityType.Builder.of(OutstretchFurnaceBlockEntity::new, SEASHALE_FURNACE.get(), EXAMPLE_1_FURNACE.get(), EXAMPLE_2_FURNACE.get()).build(null));
    public static final Supplier<BlockEntityType<OutstretchFurnaceBlockEntity>> OUTSTRETCH_FURNACE_BE = BLOCK_ENTITIES.register("outstretch_furnace", () -> BlockEntityType.Builder.of(OutstretchFurnaceBlockEntity::new,
            SEASHALE_FURNACE.get(), ANDESITE_FURNACE.get(), DIORITE_FURNACE.get(), GRANITE_FURNACE.get(), TUFF_FURNACE.get(), DRIPSTONE_FURNACE.get(), SANDSTONE_FURNACE.get(), RED_SANDSTONE_FURNACE.get(), NETHERRACK_FURNACE.get(), END_STONE_FURNACE.get()).build(null));


    private static Supplier<Block> registerBlock(String id, Supplier<Block> block, CreativeModeTab tab, Block followBlock) {
        Supplier<Block> register = BLOCKS.register(id, block);
        OUItems.ITEMS.register(id, () -> new FollowItemLike(register.get(), new Item.Properties(), tab, followBlock));
        return register;
    }
}


