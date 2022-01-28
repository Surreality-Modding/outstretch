package com.surrealitymodding.outstretch.core.forge;

import com.surrealitymodding.outstretch.core.Outstretch;
import net.minecraftforge.fml.common.Mod;

@Mod(Outstretch.MOD_ID)
public class OutstretchForge {
    public OutstretchForge() {
        Outstretch.PLATFORM.setup();
    }
}
