package com.surrealitymodding.outstretch.core.registry.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

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

    public RotatedPillarBlock rotatedPillarBlock() {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, stoneColor).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE));
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

}
