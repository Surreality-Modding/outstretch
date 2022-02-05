package com.surrealitymodding.outstretch.core.registry.util;

import com.surrealitymodding.outstretch.common.block.OutstretchFurnaceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public record Stoneset(MaterialColor stoneColor, MaterialColor materialColor){
    private static Boolean never(BlockState arg, BlockGetter arg2, BlockPos arg3, EntityType<?> arg4) {
        return false;
    }

    private RotatedPillarBlock template_material(MaterialColor arg, MaterialColor arg2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, (arg3) -> arg3.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? arg : arg2).strength(2.0F).sound(SoundType.STONE));
    }

    private RotatedPillarBlock template_stone(MaterialColor arg) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, arg).strength(2.0F).sound(SoundType.STONE));
    }


    public Block block() {
        return new Block(BlockBehaviour.Properties.of(Material.STONE, stoneColor).strength(2.0F, 3.0F).sound(SoundType.STONE));
    }

    public Block gravelBlock() {
        return new GravelBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NETHERRACK));
    }

    public RotatedPillarBlock rotatedPillarBlock() {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, stoneColor).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE));
    }

    //TODO: Haunted when makeing a new one of these go into the acesswidner and make a new one because then the error is annoying and the game cant run after you jar it
    //For example SlabBlock has an acesswidner thats why it works, alr?
    public FurnaceBlock furnaceBlock(){
        return new OutstretchFurnaceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13)));
    }

    public SlabBlock slab() {
        return new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, stoneColor).strength(2.0F, 3.0F).sound(SoundType.STONE));
    }

    public StairBlock stairs(Supplier<Block> planks) {
        return new StairBlock(planks.get().defaultBlockState(), BlockBehaviour.Properties.copy(planks.get()));
    }

    public PressurePlateBlock pressurePlate() {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.STONE, stoneColor).noCollission().strength(0.5F).sound(SoundType.STONE));
    }

    public StoneButtonBlock button() {
        return new StoneButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.STONE));
    }

    public WallBlock wall() {
        return new WallBlock(BlockBehaviour.Properties.of(Material.STONE, stoneColor).strength(2.0F, 3.0F).sound(SoundType.STONE));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (blockState) -> {
            return (Boolean)blockState.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

}
