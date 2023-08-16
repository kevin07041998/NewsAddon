package de.redstone.core.listener;

import de.redstone.core.NewsAddon;
import java.util.UUID;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class MessageIncomeListener {
  private final NewsAddon newsAddon;
  private String lastMessage = UUID.randomUUID().toString();
  public MessageIncomeListener(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Subscribe
  public void onChatReceiveEvent(ChatReceiveEvent event) {
    String unformattedText = event.chatMessage().getPlainText();
    String   formattedText = event.chatMessage().getFormattedText();

    if(unformattedText.equals(lastMessage) || unformattedText.trim().isEmpty()) {
      return;
    }

    if (event.chatMessage().getPlainText().contains("------------- ***** WERBUNG ***** -------------")) {
      newsAddon.seconds120 = 120;
      newsAddon.seconds90 = 90;
    } else if (formattedText.contains("Werbetext: ") &&
        !(formattedText.contains("Ⓡ") || formattedText.contains("Flüstern") || formattedText.contains("FUNK] (") || formattedText.contains("Ⓢ"))) {
      String werbetext = unformattedText.replaceAll(".*Werbetext: ", "");
      werbetext = werbetext
          .replace("&\uF8FF", "&")
          .replace("§a", "")
          .replace("§r", "")
          .replace("§7", "")
          .replaceAll("reperatur", "Reparatur")
          .replaceAll("Reperatur", "Reparatur")
          .replaceAll("reperaturbücher", "Reparaturbücher")
          .replaceAll("Reperaturbücher", "Reparaturbücher");

      try {
        new Thread( new Runnable() {
          public void run()  {
            try  { Thread.sleep( 10 ); }
            catch (InterruptedException ignored)  {}
            newsAddon.playerUtils.displayPrefix("§aDer Werbetext wurde in die Zwischenablage kopiert.");
          }
        } ).start();
          newsAddon.labyAPI().minecraft().setClipboard(werbetext);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    if(newsAddon.scanner && unformattedText.toLowerCase().contains(newsAddon.scan_name)) {
      String[] segments = unformattedText.split(" » ");
      lastMessage = unformattedText +" [C] ";

      newsAddon.playerUtils.clickableCommand(formattedText +" §7[§aC§7] §r", segments[segments.length -1], false);

      event.setCancelled(true);
    }
  }
}
