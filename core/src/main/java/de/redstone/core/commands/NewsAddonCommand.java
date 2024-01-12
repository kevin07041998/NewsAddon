package de.redstone.core.commands;

import de.redstone.core.NewsAddon;
import net.labymod.api.client.chat.command.Command;

public class NewsAddonCommand extends Command {
    private final NewsAddon newsAddon;

    public NewsAddonCommand(NewsAddon newsAddon) {
        super("newsaddon", "news");

        this.newsAddon = newsAddon;
        //this.withSubCommand(new ExamplePingSubCommand());
    }

    @Override
    public boolean execute(String prefix, String[] args) {
        if (args.length == 0) {
            newsAddon.playerUtils.displayPrefix("");
            newsAddon.playerUtils.displayPrefix("§aAktuelle Version: " + NewsAddon.VERSION);
            newsAddon.playerUtils.displayPrefix("§e/newsaddon §e[help, hv1, hv2, illegal, warn, scan, show, update]");
            newsAddon.playerUtils.displayPrefix("§e/auktion [item, code, gs, mie, auto]");
            newsAddon.playerUtils.displayPrefix("");

            newsAddon.seconds90 = 3;
            return true;
        }

        if (args[0].startsWith("hv") && !args[0].equals("hv2")) {
            newsAddon.playerUtils.displayPrefix("§8§l---*--- §cGERMAN§6MINER§8-§aNEWS§8-§l§oAddon§r§8§l ---*---");
            newsAddon.playerUtils.displayPrefix(" ");
            newsAddon.playerUtils.displayPrefix("§e§oPvP im Gebäude §7»§r §c3 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oRaubüberfall im Gebäude §7»§r §c3 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oMord am News-Gelände §7»§r §c10 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oMord an Newsler im Dienst (egal wo) §7»§r §c5 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oSKV auf dem Gelände §7»§r §c3 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oKlingelmissbrauch §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oEinbrechen ins Gebäude §7»§r §c4 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oNicht nachkommen einer Aufforderung §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oBetreten des Geländes trotz HV §7»§r §c4 Tage");
            newsAddon.playerUtils.displayPrefix(" ");
            newsAddon.playerUtils.displayPrefix("§e/newsaddon hv2 §7»§r §cHausverbote Teil 2");
            newsAddon.playerUtils.displayPrefix(" ");
            newsAddon.playerUtils.displayPrefix("§8§l---*--- §cGERMAN§6MINER§8-§aNEWS§8-§l§oAddon§r§8§l ---*---");
        } else if (args[0].equals("hv2")) {
            newsAddon.playerUtils.displayPrefix("§8§l---*--- §cGERMAN§6MINER§8-§aNEWS§8-§l§oAddon§r§8§l ---*---");
            newsAddon.playerUtils.displayPrefix("§e§oTiermord auf dem Gelände §7»§r §c5 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oMissbrauch der Neuigkeiten-App §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oEinbrechen in den TB-Raum §7»§r §c2 Tage, während TB 3 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oProvokantes Verhalten §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oBeleidigen eines Newslers §7»§r §c1 Tag");
            newsAddon.playerUtils.displayPrefix("§e§oDauerparken (nur von Frak.leitung) §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oMit dem Auto auf dem Gelände fahren §7»§r §c2 Tage");
            newsAddon.playerUtils.displayPrefix("§e§oAndere Sachen §7»§r §c1 Tag");
            newsAddon.playerUtils.displayPrefix(" ");
            newsAddon.playerUtils.displayPrefix("§8§l---*--- §cGERMAN§6MINER§8-§aNEWS§8-§l§oAddon§r§8§l ---*---");
        } else if (args[0].equals("illegal")) {
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cMöglich Illegale Items");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cSchutzwesten: SK3, SK2");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cMunition: 9mm, 12mm, 18mm, Schrot, Flugabwehr");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cWaffen: Raketenwerfer, M16, M4A1, M4A1-S");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cWaffen: Schrot, Jagdmesser, M1911-Colt");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cWaffen: G22, AK-47 (Kalaschnikow), Pfefferspray");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cDrogen: Heroin, Kokain (Koks), Cannabis");
            newsAddon.playerUtils.displayPrefix("§e§oIllegal §7»§r §cDrogen: Hanfsamen, Ecstasy, Tilidin");
        } else if (args[0].equals("warn")) {
            if (!(args.length > 1)) {
                newsAddon.playerUtils.displayPrefix("§e/newsaddon warn [pvp1,pvp2,pvp3,hv1,hv2,hv3,1,2,3]");
            } else {
                switch (args[1]) {
                    case "pvp1" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Bitte unterlasse das PVP auf unserem News-Gelände! (Verwarnung 1/2)");

                    case "pvp2" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Bitte unterlasse das PVP auf unserem News-Gelände! (Verwarnung 2/2)");

                    case "pvp3", "3" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Du hast nun Hausverbot auf unserem Gelände! Bitte verlasse es umgehend oder wir werden die Polizei rufen!");

                    case "hv1" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Du hast momentan Hausverbot auf unserem Gelände, bitte verlasse es umgehend! (Verwarnung 1/2)");

                    case "hv2" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Du hast momentan Hausverbot auf unserem Gelände, bitte verlasse es umgehend! (Verwarnung 2/2)");

                    case "hv3" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Du hast momentan Hausverbot auf unserem Gelände. Da du dieses nicht verlassen willst werde ich die Polizei rufen!");

                    case "1" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Bitte unterlasse das, sonst bekommst du Hausverbot! (Verwarnung 1/2)");

                    case "2" -> newsAddon.playerUtils.sendAsPlayer(
                            "✸ Achtung ✸ Bitte unterlasse das, sonst bekommst du Hausverbot! (Verwarnung 2/2)");

                    default -> newsAddon.playerUtils.displayPrefix(
                            "§e/newsaddon warn [pvp1,pvp2,pvp3,hv1,hv2,hv3,1,2,3]");
                }
            }
        } else if (args[0].equals("scan") || args[0].equals("scanner")) {
            if (!(args.length >= 2)) {
                newsAddon.playerUtils.displayPrefix("§e/newsaddon scan [Name,stop]");
            } else {
                if (args[1].equalsIgnoreCase("stop") || (
                        args[1].equalsIgnoreCase(newsAddon.last_scanned_name) && newsAddon.scanner)) {
                    newsAddon.scan_name = null;
                    newsAddon.scanner = false;
                    newsAddon.playerUtils.displayPrefix("§cScanner aus");
                } else {
                    newsAddon.scan_name = args[1];
                    newsAddon.scanner = true;
                    newsAddon.playerUtils.displayPrefix("§aScanne nun " + args[1]);
                    newsAddon.last_scanned_name = args[1];
                }
            }
     /*else if(args[1].equals("da") || args[1].startsWith("dauerauftr")) {
      newsAddon.playerUtils.displayPrefix("§aFolgende DAs sind für heute abgespeichert:");
      for(String item : newsAddon.das) {
        newsAddon.playerUtils.displayPrefix("§a" + item);
      }
      newsAddon.playerUtils.displayPrefix("");
    } else if(args[1].equals("update")) {
      newsAddon.playerUtils.displayPrefix("§aPrüfe in 10 Sekunden auf Updates. Sollte ein Update verfügbar sein, wirst du benachrichtigt.");
      UpdateChecker.initialize(NewsAddon.VERSION);
    } else if(args[1].equals("reinstall")) {
      newsAddon.playerUtils.displayPrefix("§aInstalliere aktuelles Addon in wenigen Sekunden neu.");
      UpdateChecker.initialize(0);*/
        } else {
            newsAddon.playerUtils.displayPrefix("");
            newsAddon.playerUtils.displayPrefix("§aAktuelle Version: " + NewsAddon.VERSION);
            newsAddon.playerUtils.displayPrefix("§e/newsaddon §e[help, hv1, hv2, illegal, warn, scan, show, update]");
            newsAddon.playerUtils.displayPrefix("§e/auktion [item, code, gs, mie, auto]");
            newsAddon.playerUtils.displayPrefix("");
        }
        return true;
    }
}
