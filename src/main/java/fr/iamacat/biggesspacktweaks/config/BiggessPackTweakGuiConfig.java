package fr.iamacat.biggesspacktweaks.config;

import net.minecraft.client.gui.GuiScreen;

import com.falsepattern.lib.config.ConfigException;
import com.falsepattern.lib.config.SimpleGuiConfig;

import fr.iamacat.biggesspacktweaks.Tags;

public class BiggessPackTweakGuiConfig extends SimpleGuiConfig {

    public BiggessPackTweakGuiConfig(GuiScreen parent) throws ConfigException {
        super(parent, BiggessPackTweakConfig.class, Tags.MODID, Tags.MODNAME);
    }
}
