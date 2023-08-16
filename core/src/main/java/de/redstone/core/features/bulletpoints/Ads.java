package de.redstone.core.features.bulletpoints;

import de.redstone.core.NewsAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.player.Player;
import net.labymod.api.client.entity.player.interaction.BulletPoint;
import net.labymod.api.client.gui.icon.Icon;

public class Ads implements BulletPoint {
  private final NewsAddon newsAddon;

  public Ads(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Override
  public Component getTitle() {
    return Component.text("§7[§aN§7]§f Werbearten");
  }

  @Override
  public Icon getIcon() {
    return null;
  }

  @Override
  public void execute(Player player) {
    newsAddon.playerUtils.sendAsPlayerWithoutHistory("Welche Art von Werbung möchtest du schalten? Chatwerbung (350€), Actionbarwerbung (200€), Appwerbung (1120€) oder Zeitungswerbung?");
  }
}
