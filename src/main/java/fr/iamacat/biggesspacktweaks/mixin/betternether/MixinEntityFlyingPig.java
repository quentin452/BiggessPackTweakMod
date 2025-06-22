package fr.iamacat.biggesspacktweaks.mixin.betternether;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import someoneelse.betternetherreforged.entity.EntityFlyingPig;

@Mixin(EntityFlyingPig.class)
public abstract class MixinEntityFlyingPig {
    /**
     * Redirects the setMotion/func_70016_h call in FindFoodGoal.func_75251_c to ensure compatibility.
     */
    @Redirect(
            method = "func_75251_c",
            at = @At(

                    value = "INVOKE",

                    target = "Lsomeoneelse/betternetherreforged/entity/EntityFlyingPig;func_70016_h(DDD)V"
            )
    )
    private void redirectSetMotion(EntityFlyingPig instance, double x, double y, double z) {
        instance.setMotion(x, y, z);
    }
}