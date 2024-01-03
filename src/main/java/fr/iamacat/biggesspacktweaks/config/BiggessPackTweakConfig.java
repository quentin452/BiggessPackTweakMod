package fr.iamacat.biggesspacktweaks.config;

import com.falsepattern.lib.config.Config;

import fr.iamacat.biggesspacktweaks.Tags;

@Config(modid = Tags.MODID)
public class BiggessPackTweakConfig {
    @Config.Comment("Disabling Thaumonomicon book from Thaumcraft to prevent https://github.com/quentin452/privates-minecraft-modpack/issues/908")
    @Config.DefaultBoolean(true)
    @Config.RequiresWorldRestart
    public static boolean disablingThaumonomiconbookfromThaumcraft;

}
