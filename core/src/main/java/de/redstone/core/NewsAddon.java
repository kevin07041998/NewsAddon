package de.redstone.core;

import de.redstone.core.commands.AuktionCommand;
import de.redstone.core.commands.NewsAddonCommand;
import de.redstone.core.commands.NfCommand;
import de.redstone.core.features.bulletpoints.Ads;
import de.redstone.core.features.bulletpoints.Greet;
import de.redstone.core.features.bulletpoints.Scan;
import de.redstone.core.listener.MessageIncomeListener;
import de.redstone.core.timer.WerbeTimer;
import de.redstone.core.utils.PlayerUtils;
import de.redstone.core.widgets.Werbung120Timer;
import de.redstone.core.widgets.Werbung90Timer;
import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@AddonMain
public class NewsAddon extends LabyAddon<NewsAddonConfiguration> {
  public static final String VERSION = "1.0 - LM4";
  public PlayerUtils playerUtils = new PlayerUtils(this);
  public Werbung120Timer werbung120Timer;
  public Werbung90Timer werbung90Timer;
  public NfCommand nfCommand;
  //Bulletpoints for PlayerWheel
  public Greet greet;
  public Ads ads;
  public Scan scan;
  public final boolean DEBUGMODE = true;
  public int seconds120 = 0;
  public int seconds90 = 0;
  public String scan_name;
  public boolean scanner;
  public String last_scanned_name;
  public String sound90Sec;
  public String sound120Sec;
  public String soundDASec;
  public List<String> das = new ArrayList<>();
  public boolean ws_timeout;
  public String ws = "ws://janheist.dev:8181";
  public SocketConnection socketConnection;
  public SocketConnection getSocketConnection() {
    return socketConnection;
  }

  @Override
  protected void enable() {
    this.registerSettingCategory();

    NewsAddonConfiguration config = null;
    try {
      config = configurationClass().newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert config != null;
    this.sound90Sec = config.sound90().get();
    this.sound120Sec = config.sound120().get();
    this.soundDASec = config.soundDA().get();

    try {
      this.socketConnection = new SocketConnection(new URI(this.ws), this);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    this.registerListener(new MessageIncomeListener(this));
    this.registerCommand(new AuktionCommand(this));
    this.registerCommand(new NewsAddonCommand(this));
    this.registerCommand(new NfCommand(this));

    Laby.references().hudWidgetRegistry().register(this.werbung120Timer = new Werbung120Timer(this));
    Laby.references().hudWidgetRegistry().register(this.werbung90Timer = new Werbung90Timer(this));
    Laby.references().labyAPI().interactionMenuRegistry().register(this.greet = new Greet(this));
    Laby.references().labyAPI().interactionMenuRegistry().register(this.ads = new Ads(this));
    Laby.references().labyAPI().interactionMenuRegistry().register(this.scan = new Scan(this));

    Timer timer = new Timer();
    timer.schedule(new WerbeTimer(this),0, 1000);


    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<NewsAddonConfiguration> configurationClass() {
    return NewsAddonConfiguration.class;
  }
}
