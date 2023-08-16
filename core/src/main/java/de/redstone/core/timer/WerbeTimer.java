package de.redstone.core.timer;

import de.redstone.core.NewsAddon;
import java.util.TimerTask;

public class WerbeTimer extends TimerTask {
  NewsAddon newsAddon;
  public WerbeTimer(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Override
  public void run() {
    if (newsAddon.seconds120 > 0) {
      newsAddon.seconds120 = newsAddon.seconds120 - 1;
    }

    if (newsAddon.seconds90 > 0) {
      newsAddon.seconds90 = newsAddon.seconds90 - 1;
    }

    newsAddon.werbung120Timer.setTimer(newsAddon.seconds120);
    newsAddon.werbung90Timer.setTimer(newsAddon.seconds90);
  }
}
