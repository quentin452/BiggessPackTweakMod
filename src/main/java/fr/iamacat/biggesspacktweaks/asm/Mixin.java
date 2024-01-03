package fr.iamacat.biggesspacktweaks.asm;

import java.util.*;
import java.util.function.Predicate;

import com.falsepattern.lib.mixin.IMixin;
import com.falsepattern.lib.mixin.ITargetedMod;

import fr.iamacat.biggesspacktweaks.config.BiggessPackTweakConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Mixin implements IMixin {

    // TWEAKING MIXINS
    common_thaumcraft_MixinItemThaumonomicon(Side.COMMON,
        require(TargetedMod.THAUMCRAFT4).and(m -> BiggessPackTweakConfig.disablingThaumonomiconbookfromThaumcraft),
        "thaumcraft.MixinItemThaumonomicon")

    // MOD-FILTERED MIXINS

    // The modFilter argument is a predicate, so you can also use the .and(), .or(), and .negate() methods to mix and
    // match multiple predicates.
    ;

    @Getter
    public final Side side;
    @Getter
    public final Predicate<List<ITargetedMod>> filter;
    @Getter
    public final String mixin;

    static Predicate<List<ITargetedMod>> require(TargetedMod in) {
        return modList -> modList.contains(in);
    }

    static Predicate<List<ITargetedMod>> avoid(TargetedMod in) {
        return modList -> !modList.contains(in);
    }
}
