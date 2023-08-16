package de.redstone.core.features.bulletpoints;

import de.redstone.core.NewsAddon;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.player.Player;
import net.labymod.api.client.entity.player.interaction.BulletPoint;
import net.labymod.api.client.gui.icon.Icon;

public class Scan implements BulletPoint {
  private final NewsAddon newsAddon;

  public Scan(NewsAddon newsAddon) {
    this.newsAddon = newsAddon;
  }

  @Override
  public Component getTitle() {
    return Component.text("§7[§aN§7]§f Scan");
  }

  @Override
  public Icon getIcon() {
    return null;
  }

  @Override
  public void execute(Player player) {
    newsAddon.playerUtils.sendAsPlayerWithoutHistory("/newsaddon scan "+ player.getName().toLowerCase());
  }
}
