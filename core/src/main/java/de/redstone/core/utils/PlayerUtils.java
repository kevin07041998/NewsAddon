package de.redstone.core.utils;

import de.redstone.core.NewsAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.chat.ChatMessage;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.event.ClickEvent;
import net.labymod.api.client.options.ChatVisibility;

public class PlayerUtils {

  public String PREFIX = "§7[§a§lNEWS§r§7] §r";
  private final NewsAddon addon;

  public PlayerUtils(NewsAddon addon) {
    this.addon = addon;
  }

  public void displayNormal(String message) {
    ChatMessage chatMessage = ChatMessage.builder()
        .component(Component.text(message))
        .visibility(ChatVisibility.SHOWN)
        .build();
    addon.labyAPI().chatProvider().chatController().addMessage(chatMessage);
  }

  public void displayPrefix(String message) {
    ChatMessage chatMessage = ChatMessage.builder()
        .component(Component.text(PREFIX + message))
        .visibility(ChatVisibility.SHOWN)
        .build();
    addon.labyAPI().chatProvider().chatController().addMessage(chatMessage);
  }

  public void clickableCommand(String message, String command, boolean prefix) {
    ChatMessage chatMessage;

    if (prefix) {
      chatMessage = ChatMessage.builder()
          .component(Component.text(PREFIX + message)
              .clickEvent(ClickEvent.suggestCommand(command))) // Add the click event
          .visibility(ChatVisibility.SHOWN)
          .build();
    } else {
      chatMessage = ChatMessage.builder()
          .component(Component.text(message)
              .clickEvent(ClickEvent.suggestCommand(command))) // Add the click event
          .visibility(ChatVisibility.SHOWN)
          .build();
    }
    addon.labyAPI().chatProvider().chatController().addMessage(chatMessage);
  }

  public void sendAsPlayer(String message) {
    Laby.references().chatExecutor().chat(message);
  }

  public void sendAsPlayerWithoutHistory(String message) {
    Laby.references().chatExecutor().chat(message, false);
  }
}