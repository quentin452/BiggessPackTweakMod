package fr.iamacat.biggesspacktweaks.mixin.core;


import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.chunk.storage.IOWorker;

@Mixin(Util.class)
public abstract class MixinUtil {

    /**
     * Replaces the GLFW call with System.nanoTime() on the server
     * to avoid the cost of JNI calls caused by getAsLong().
     */
    @Overwrite
    public static long nanoTime() {
        return System.nanoTime();
    }
}