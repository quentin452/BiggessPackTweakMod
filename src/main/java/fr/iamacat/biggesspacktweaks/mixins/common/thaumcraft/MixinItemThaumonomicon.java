package fr.iamacat.biggesspacktweaks.mixins.common.thaumcraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import thaumcraft.common.items.relics.ItemThaumonomicon;

@Mixin(ItemThaumonomicon.class)
public class MixinItemThaumonomicon {
    /**
     * @author iamacatfr
     * @reason disabling right-click to open the Thaumonomicon to prevent <a href="https://github.com/quentin452/privates-minecraft-modpack/issues/908">...</a>
     */
    @Overwrite(remap = false)
    public ItemStack func_77659_a(ItemStack stack, World par2World, EntityPlayer player) {
        return stack;
    }
}
