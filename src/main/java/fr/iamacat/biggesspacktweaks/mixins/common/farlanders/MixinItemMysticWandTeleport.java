package fr.iamacat.biggesspacktweaks.mixins.common.farlanders;

import com.fabiulu.farlanders.common.item.ItemMysticWandTeleport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ItemMysticWandTeleport.class)
public class MixinItemMysticWandTeleport extends Item {
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player) {
        return itemStack;
    }

}
