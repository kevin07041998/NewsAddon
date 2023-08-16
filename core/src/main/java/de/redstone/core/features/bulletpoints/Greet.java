package de.redstone.core.features.bulletpoints;

import de.redstone.core.NewsAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.player.Player;
import net.labymod.api.client.entity.player.interaction.BulletPoint;
import net.labymod.api.client.gui.icon.Icon;

public class Greet implements BulletPoint {
  private final NewsAddon newsAddon;

  public Greet(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Override
  public Component getTitle() {
    return Component.text("§7[§aN§7]§f Grüßen");
  }

  @Override
  public Icon getIcon() {
    return null;
  }

  @Override
  public void execute(Player player) {
    newsAddon.playerUtils.sendAsPlayerWithoutHistory("Hallo "+player.getName()+ ". Willkommen in der News-Zentrale. Wie kann ich weiterhelfen?");
  }
}
