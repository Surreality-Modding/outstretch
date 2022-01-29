package com.surrealitymodding.outstretch.core.registry;

import com.surrealitymodding.outstretch.core.Outstretch;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public class OUItems {
    public static final PollinatedRegistry<Item> ITEMS = PollinatedRegistry.create(Registry.ITEM, Outstretch.MOD_ID);
}
