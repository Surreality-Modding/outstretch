package com.surrealitymodding.outstretch.core.fabric;

import com.surrealitymodding.outstretch.core.Outstretch;
import net.fabricmc.api.ModInitializer;

public class OutstretchFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Outstretch.PLATFORM.setup();
    }
}
