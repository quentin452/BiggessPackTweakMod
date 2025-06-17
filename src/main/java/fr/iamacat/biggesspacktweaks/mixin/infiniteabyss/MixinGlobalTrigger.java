/**
 * Mixin on Infinite Abyss's internal GlobalTrigger procedure used to limit how often the trigger runs.
 *
 * This throttle prevents the procedure from executing on every world tick
 * by introducing a simple tick counter per world.
 * It effectively reduces the frequency to once every 20 ticks (1 second),
 * helping reduce potential lag or excessive logic executions.
 *
 */
package fr.iamacat.biggesspacktweaks.mixin.infiniteabyss;

import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.WeakHashMap;

@Mixin(targets = "net.mcreator.infiniteabyss.procedures.GlobalTimerProcedure$GlobalTrigger")
public abstract class MixinGlobalTrigger {

    @Unique
    private static final Map<World, Integer> infiniteAbyss$tickCounters = new WeakHashMap<>();

    @Inject(
            method = "onWorldTick(Lnet/minecraftforge/event/TickEvent$WorldTickEvent;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void throttleGlobalTimer(TickEvent.WorldTickEvent event, CallbackInfo ci) {
        if (event.phase != TickEvent.Phase.END || event.world.isRemote()) {
            return;
        }

        World world = event.world;
        int tickCount = infiniteAbyss$tickCounters.getOrDefault(world, 0) + 1;

        if (tickCount < 20) {
            infiniteAbyss$tickCounters.put(world, tickCount);
            ci.cancel();
        } else {
            infiniteAbyss$tickCounters.put(world, 0);
        }
    }
}