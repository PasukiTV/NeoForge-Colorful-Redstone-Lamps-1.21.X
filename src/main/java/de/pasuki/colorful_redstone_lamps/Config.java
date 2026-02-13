package de.pasuki.colorful_redstone_lamps;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // Intentionally left minimal for now; this keeps a stable place for future options.
    public static final ModConfigSpec SPEC = BUILDER.build();

    private Config() {
    }
}
