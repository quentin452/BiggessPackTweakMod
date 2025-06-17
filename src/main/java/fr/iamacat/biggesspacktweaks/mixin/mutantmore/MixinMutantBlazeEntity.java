package fr.iamacat.biggesspacktweaks.mixin.mutantmore;

import com.alexander.mutantmore.entities.MutantBlazeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import java.io.PrintStream;

@Mixin(MutantBlazeEntity.class)
public class MixinMutantBlazeEntity {

    // FIX UNECESSARY SPAM LOG
    @Redirect(
            method = "func_70030_z",
            remap = false,
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/io/PrintStream;print(Ljava/lang/String;)V",
                    remap = false
            )
    )
    private void redirectSystemOutPrint(PrintStream stream, String message) {
        if (message != null && !message.startsWith("\r\n")) {
            stream.print(message);
        }
    }
}
