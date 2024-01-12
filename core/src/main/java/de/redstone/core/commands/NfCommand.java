package de.redstone.core.commands;

import de.redstone.core.NewsAddon;
import de.redstone.core.utils.PlayerUtils;
import net.labymod.api.client.chat.command.Command;

public class NfCommand extends Command {
    private final NewsAddon newsAddon;
    private final PlayerUtils playerUtils;

    public NfCommand(NewsAddon newsAddon) {
        super("nf");

        this.newsAddon = newsAddon;
        this.playerUtils = new PlayerUtils(newsAddon);
        //this.withSubCommand(new ExamplePingSubCommand());
    }

    @Override
    public boolean execute(String prefix, String[] args) {
        System.out.println(args.length);

        if (args.length == 0) {
            playerUtils.displayPrefix("");
            playerUtils.displayPrefix("§aAktuelle Version: " + NewsAddon.VERSION);
            playerUtils.displayPrefix("§e/nf §e[connect, connected, close, <msg>]");
            playerUtils.displayPrefix("");

            return true;
        }
        try {
            if (args[0].equalsIgnoreCase("connect")) {
                newsAddon.getSocketConnection().connectSocket();
            } else if (args[0].equalsIgnoreCase("close")) {
                newsAddon.getSocketConnection().s("plsKillMe");
            } else if (args[0].equals("veryUnusualStringThatAPlayerWouldSendToTheServer")) {
                playerUtils.displayPrefix("");
                playerUtils.displayPrefix("§aAktuelle Version: " + NewsAddon.VERSION);
                playerUtils.displayPrefix("§e/nf §e[connect, connected, close, <msg>]");
                playerUtils.displayPrefix("");
            } else if (args[0].equals("connected")) {
                newsAddon.getSocketConnection().s("plsGetConnected §TOKEN§");
            } else {
                String message;
                StringBuilder b = new StringBuilder();
                for (String arg : args) {
                    b.append(arg);
                    b.append(" ");
                }
                message = b.toString();

                System.out.printf(b.toString());
                newsAddon.getSocketConnection().s("nf §TOKEN§ " + message);
            }
        } catch (NullPointerException e) {
            playerUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Du bist nicht mit dem Server verbunden!");
            newsAddon.getSocketConnection().connectSocket();
        }

        return true;
    }
}
