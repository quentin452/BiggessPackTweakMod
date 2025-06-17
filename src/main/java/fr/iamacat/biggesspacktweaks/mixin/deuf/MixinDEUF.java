package fr.iamacat.biggesspacktweaks.mixin.deuf;

import de.cas_ual_ty.deuf.DEUF;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DEUF.class)
public class MixinDEUF {

    @Redirect(
            method = "fix",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V"
            ),
            remap = false
    )
    private void suppressLoggerInfo(Logger logger, String message, Object p0, Object p1, Object p2) {
    }
}