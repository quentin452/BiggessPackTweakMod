package fr.iamacat.biggesspacktweaks.mixin.cyclic;

import com.lothrazar.cyclic.enchant.EnchantExcavation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantExcavation.class)
public abstract class MixinEnchantExcavation extends Enchantment {

    protected MixinEnchantExcavation(Rarity p_i46731_1_, EnchantmentType p_i46731_2_, EquipmentSlotType[] p_i46731_3_) {
        super(p_i46731_1_, p_i46731_2_, p_i46731_3_);
    }

    @Overwrite(remap = false)
    public boolean isEnabled() {
        return false;
    }
    /**
     * Désactive complètement l'effet de l'enchantement
     */
    @Inject(
            method = "onBreakEvent",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void disableExcavationEffect(BlockEvent.BreakEvent event, CallbackInfo ci) {
        ci.cancel(); // Annule tout traitement de l'événement
    }

    /**
     * Empêche l'enchantement d'être appliqué sur les outils
     */
    @Override
    public boolean canApply(ItemStack stack) {
        return false;
    }

    /**
     * Rend l'enchantement invisible dans le jeu
     */
    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }

    /**
     * Désactive l'enchantement dans les tables d'enchantement
     */
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
}