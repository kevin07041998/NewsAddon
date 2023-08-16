package de.redstone.core.listener;

import de.redstone.core.NewsAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class MessageIncomeListener {
  private final NewsAddon newsAddon;
  public MessageIncomeListener(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Subscribe
  public void onChatReceiveEvent(ChatReceiveEvent event) {
    if (event.chatMessage().getPlainText().contains("Werbung")) {
      newsAddon.seconds120 = 120;
      newsAddon.seconds90 = 90;
    }
  }
}
