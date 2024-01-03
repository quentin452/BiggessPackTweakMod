package fr.iamacat.biggesspacktweaks.config;

import net.minecraft.client.gui.GuiScreen;

import com.falsepattern.lib.config.SimpleGuiFactory;

public class BiggessPackTweakGuiConfigFactory implements SimpleGuiFactory {

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return BiggessPackTweakGuiConfig.class;
    }
}
