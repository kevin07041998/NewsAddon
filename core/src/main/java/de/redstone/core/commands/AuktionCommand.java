package de.redstone.core.commands;

import de.redstone.core.NewsAddon;
import de.redstone.core.features.Auctions;
import net.labymod.api.client.chat.command.Command;

public class AuktionCommand extends Command {
  private final Auctions auctions;
  public AuktionCommand(NewsAddon newsAddon) {
    super("auktion");

    auctions = new Auctions(newsAddon);
    //this.withSubCommand(new ExamplePingSubCommand());
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    auctions.startAuction(arguments);
    return true;
  }
}
