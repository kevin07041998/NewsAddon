package de.redstone.core;

import de.redstone.core.commands.AuktionCommand;
import de.redstone.core.commands.NewsAddonCommand;
import de.redstone.core.listener.MessageIncomeListener;
import de.redstone.core.timer.WerbeTimer;
import de.redstone.core.utils.PlayerUtils;
import de.redstone.core.widgets.Werbung120Timer;
import de.redstone.core.widgets.Werbung90Timer;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import java.util.Timer;

@AddonMain
public class NewsAddon extends LabyAddon<NewsAddonConfiguration> {
  public final String VERSION = "1.0 - LM4";
  public Werbung120Timer werbung120Timer;
  public Werbung90Timer werbung90Timer;
  public int seconds120 = 0;
  public int seconds90 = 0;
  public PlayerUtils playerUtils = new PlayerUtils(this);

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new MessageIncomeListener(this));
    this.registerCommand(new AuktionCommand(this));
    this.registerCommand(new NewsAddonCommand(this));

    Laby.references().hudWidgetRegistry().register(this.werbung120Timer = new Werbung120Timer(this));
    Laby.references().hudWidgetRegistry().register(this.werbung90Timer = new Werbung90Timer(this));

    Timer timer = new Timer();
    timer.schedule(new WerbeTimer(this),0, 1000);


    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<NewsAddonConfiguration> configurationClass() {
    return NewsAddonConfiguration.class;
  }
}
