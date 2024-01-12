package de.redstone.core;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;

@ConfigName("settings")
public class NewsAddonConfiguration extends AddonConfig {
    @SettingSection("90")
    @SwitchSetting
    private final ConfigProperty<Boolean> isSound90 = new ConfigProperty<>(false);
    @TextFieldWidget.TextFieldSetting
    private final ConfigProperty<String> sound90 = new ConfigProperty<>("block.note.pling");

    @SettingSection("120")
    @SwitchSetting
    private final ConfigProperty<Boolean> isSound120 = new ConfigProperty<>(true);
    @TextFieldWidget.TextFieldSetting
    private final ConfigProperty<String> sound120 = new ConfigProperty<>("block.note.pling");

    @SettingSection("DA")
    @SwitchSetting
    private final ConfigProperty<Boolean> isSoundDA = new ConfigProperty<>(true);
    @TextFieldWidget.TextFieldSetting
    private final ConfigProperty<String> soundDA = new ConfigProperty<>("");

    @SettingSection("Websocket")
    @SwitchSetting
    private final ConfigProperty<Boolean> autoconnectGM = new ConfigProperty<>(true);
    private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

    public ConfigProperty<Boolean> isSound90() {
        return this.isSound90;
    }

    public ConfigProperty<String> sound90() {
        return this.sound90;
    }

    public ConfigProperty<Boolean> isSound120() {
        return this.isSound120;
    }

    public ConfigProperty<String> sound120() {
        return this.sound120;
    }

    public ConfigProperty<Boolean> isSoundDA() {
        return this.isSoundDA;
    }

    public ConfigProperty<String> soundDA() {
        return this.soundDA;
    }

    public ConfigProperty<Boolean> autoconnectGM() {
        return this.autoconnectGM;
    }

    @Override
    public ConfigProperty<Boolean> enabled() {
        return this.enabled;
    }
}