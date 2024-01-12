package fr.iamacat.biggesspacktweaks.config;

import com.falsepattern.lib.config.Config;

import fr.iamacat.biggesspacktweaks.Tags;

@Config(modid = Tags.MODID)
public class BiggessPackTweakConfig {
    @Config.Comment("Disabling Teleporter wand from Farlanders causing infinite loop (https://github.com/quentin452/privates-minecraft-modpack/issues/917)")
    @Config.DefaultBoolean(true)
    @Config.RequiresWorldRestart
    public static boolean enableMixinItemMysticWandTeleport;

}
