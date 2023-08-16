package de.redstone.core.widgets;

import de.redstone.api.TimerWidgetConfig;
import de.redstone.core.NewsAddon;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.position.HudSize;
import net.labymod.api.client.gui.screen.widget.widgets.hud.HudWidgetWidget;

public class Werbung120Timer extends TextHudWidget<TimerWidgetConfig> {
  private TextLine timer;
  public Werbung120Timer(NewsAddon addon) {
    super("newsaddon", TimerWidgetConfig.class);
  }

  @Override
  public void load(TimerWidgetConfig config) {
    super.load(config);
    this.timer = super.createLine("120-Werbung", "Erlaubt");
  }

  @Override
  public boolean isVisibleInGame() {
    return true;
  }

  @Override
  public void updateSize(HudWidgetWidget widget, boolean isEditorContext, HudSize size) {
    size.set(25, 10);
  }

  public void setTimer(int time) {
    if (time <= 0) {
      timer.updateAndFlush("Erlaubt");
    } else {
      timer.updateAndFlush("Erlaubt in " + time + " Sekunden");
    }
  }
}
