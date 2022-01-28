package com.surrealitymodding.outstretch.core;

import gg.moonflower.pollen.api.platform.Platform;

public class Outstretch {
    public static final String MOD_ID = "outstretch";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(Outstretch::onClientInit)
            .clientPostInit(Outstretch::onClientPostInit)
            .commonInit(Outstretch::onCommonInit)
            .commonPostInit(Outstretch::onCommonPostInit)
            .dataInit(Outstretch::onDataInit)
            .build();

    public static void onClientInit() {
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onCommonInit() {
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }
}
