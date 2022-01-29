package com.surrealitymodding.outstretch.common.block.entity;

import com.surrealitymodding.outstretch.core.registry.OUBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OutstretchFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public OutstretchFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(OUBlocks.OUTSTRETCH_FURNACE_BE.get(), blockPos, blockState, RecipeType.SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new FurnaceMenu(containerId, inventory, this, this.dataAccess);
    }
}