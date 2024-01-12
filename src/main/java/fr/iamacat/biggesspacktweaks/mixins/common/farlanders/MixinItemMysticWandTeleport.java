package fr.iamacat.biggesspacktweaks.mixins.common.farlanders;

import com.fabiulu.farlanders.common.item.ItemMysticWandTeleport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

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

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Teleportation Gem(Disabled due to infinite loop)");
    }
}
