package fr.iamacat.biggesspacktweaks.mixin.cyclic;

import com.lothrazar.cyclic.util.UtilRender;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.math.BlockPos;

@Mixin(UtilRender.class)
public class MixinUtilRender {

    @Inject(
            method = "createBox(Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/util/math/BlockPos;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void onCreateBox(MatrixStack matrixStack, BlockPos pos, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(
            method = "createBox(Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/vector/Vector3d;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void onCreateBoxWithCamera(MatrixStack matrixStack, BlockPos pos, Vector3d cameraPosition, CallbackInfo ci) {
        ci.cancel();
    }
}
