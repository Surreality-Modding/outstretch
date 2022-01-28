package com.surrealitymodding.outstretch.core.fabric;

import com.surrealitymodding.outstretch.core.Outstretch;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OutstretchFabricDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        Outstretch.PLATFORM.dataSetup(dataGenerator);
    }
}
