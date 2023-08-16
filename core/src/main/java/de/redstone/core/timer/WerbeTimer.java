package de.redstone.core.timer;

import de.redstone.core.NewsAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.resources.ResourceLocation;

import java.util.TimerTask;

public class WerbeTimer extends TimerTask {
  NewsAddon newsAddon;
  public WerbeTimer(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Override
  public void run() {
    if (newsAddon.seconds120 >= 0) {
      newsAddon.seconds120 = newsAddon.seconds120 - 1;
    }

    if (newsAddon.seconds90 >= 0) {
      newsAddon.seconds90 = newsAddon.seconds90 - 1;
    }

    if (newsAddon.seconds120 == 0) {
      Laby.labyAPI().minecraft().sounds().playSound(ResourceLocation.create("minecraft", newsAddon.sound120Sec), 1.0F, 1.0F);
    }

    if (newsAddon.seconds90 == 0) {
      Laby.labyAPI().minecraft().sounds().playSound(ResourceLocation.create("minecraft", newsAddon.sound90Sec), 1.0F, 1.0F);
    }

    newsAddon.werbung120Timer.setTimer(newsAddon.seconds120);
    newsAddon.werbung90Timer.setTimer(newsAddon.seconds90);
  }
}
