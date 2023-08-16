package de.redstone.core.features;

import de.redstone.core.NewsAddon;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Auctions {
  private final List<String> itemTexte = new ArrayList<>();
  private final List<String> gsTexte = new ArrayList<>();
  private final List<String> bizTexte = new ArrayList<>();
  private final List<String> autoTexte = new ArrayList<>();
  private final List<String> codeTexte = new ArrayList<>();
  private final List<String> mieTexte = new ArrayList<>();
  private final NewsAddon addon;

  public Auctions(NewsAddon addon) {
    this.addon = addon;
    LocalDateTime localDateTime = LocalDateTime.now().plusDays(7);
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.GERMAN);
    String latestEnd = formatDate.format(localDateTime);

    itemTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern das Item versteigert wird.");
    itemTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    itemTexte.add("Wie soll der Startpreis der Auktion sein?");
    itemTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    itemTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    itemTexte.add("Als letztes bräuchte ich bitte einmal deine Kontonummer und das Item mit den 500€ Auktionsgebühr über das Handelsmenü.");

    gsTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern die Region versteigert wird.");
    gsTexte.add("Bei einer Grundstücksauktion wird die Auktion im Forum erst veröffentlicht, nachdem das Grundstück an unsere Fraktionsleitung übertragen wurde.");
    gsTexte.add("In welchem Stadtteil befindet sich die Region und wie ist die ID (kau-ID)?");
    gsTexte.add("Hat dein Grundstück einen aktiven Bebauungshinweis?");
    gsTexte.add("Wie ist der Grundpreis (Staat) und wie hoch sind die Grundsteuern?");
    gsTexte.add("Kennst du die Maße der Region?");
    gsTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    gsTexte.add("Wie soll der Startpreis in der Auktion sein?");
    gsTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    gsTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    gsTexte.add("Hast du Fotos von dem Grundstück oder soll ich welche machen?");
    gsTexte.add("Dann bekomme ich bitte noch deine Kontonummer und die 500€ Auktionsgebühr.");

    mieTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern die Region versteigert wird.");
    mieTexte.add("In welchem Stadtteil befindet sich die Mietregion und wie ist die ID (mie-ID)?");
    mieTexte.add("Wie hoch sind die Mietkosten am Tag?");
    mieTexte.add("Kennst du die Maße der Region?");
    mieTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    mieTexte.add("Wie soll der Startpreis in der Auktion sein?");
    mieTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    mieTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    mieTexte.add("Hast du Fotos oder soll ich welche machen?");
    mieTexte.add("Dann bekomme ich bitte noch deine Kontonummer und die 500€ Auktionsgebühr.");

    bizTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern das BIZ versteigert wird.");
    bizTexte.add("Welche Art von BIZ möchtest du versteigern und in welcher Region befindet es sich?");
    bizTexte.add("Dann brauche ich bitte die Übernahmekosten (Staat) und die aktuellen Miet- bzw. Pachtkosten.");
    bizTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    bizTexte.add("Wie soll der Startpreis in der Auktion sein?");
    bizTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    bizTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    bizTexte.add("Hast du Fotos vom BIZ oder soll ich welche machen?");
    bizTexte.add("Dann bekomme ich bitte noch deine Kontonummer und die 500€ Auktionsgebühr.");

    autoTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern das Vehicle versteigert wird.");
    autoTexte.add("Von welcher Marke ist das Vehicle und welches Modell ist es?");
    autoTexte.add("Besitzt das Vehicle irgendwelche Tunings?");
    autoTexte.add("Welche Farbe hat das Vehicle?");
    autoTexte.add("Welchen Reparaturzustand hat das Vehicle? Dieser muss min. 80% sein. Gerne kannst du dein Auto auch im Anschluss in der Garage beim Mechaniker reparieren.");
    autoTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    autoTexte.add("Wie soll der Startpreis in der Auktion sein?");
    autoTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    autoTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    autoTexte.add("Kennst du den aktuellen Neupreis des Vehicles?");
    autoTexte.add("Dann bräuchte ich bitte einmal deine Kontonummer und den Vehicle-Schlüssel mit den 500€ Auktionsgebühr über das Handelsmenü.");

    codeTexte.add("Bist du dir bewusst, dass die Auktion anfangs 500€ kostet? Weiterhin fallen 3% vom Gewinn Auktionsgebühr an, sofern der Gutschein versteigert wird.");
    codeTexte.add("An welchem Tag und zu welcher Uhrzeit soll die Auktion enden? (Maximal bis zum " + latestEnd + ")");
    codeTexte.add("Wie soll der Startpreis der Auktion sein?");
    codeTexte.add("Welche Summe soll für den Sofortkauf bestimmt werden?");
    codeTexte.add("In welchen Schritten sollen die Spieler mindestens bieten?");
    codeTexte.add("Dann bräuchte ich bitte einmal deine Kontonummer und die 500€ Auktionsgebühr.");
  }

  private void doAuction(List<String> msg) {
    addon.playerUtils.displayPrefix("");
    addon.playerUtils.displayPrefix("§aKlicke nun die Texte für die jeweiligen Auktionstexte an:");

    for(int i = 0; i < msg.size(); i++) {
      addon.playerUtils.clickableCommand("§a" + (i+1) + ". Auktionstext einfügen", msg.get(i), true);
    }

    addon.playerUtils.displayPrefix("");
  }

  public void startAuction(String[] message) {
    if (message.length == 0) {
      addon.playerUtils.displayPrefix("§cKorrekte Anwendung: §e/auktion [item, code, gs, mie, auto, rechner]");
      return;
    }

    message[0] = message[0].toLowerCase();
    switch (message[0]) {
      case "item":
        doAuction(itemTexte);
        break;
      case "gutschein":
      case "code":
        doAuction(codeTexte);
        addon.playerUtils.displayPrefix("§aDie Person muss nun den Code per Forenkonversation an dich und die Fraktionsleitung senden.");
        break;
      case "gs":
      case "grundstück":
      case "grundstueck":
        doAuction(gsTexte);
        addon.playerUtils.displayPrefix("§aDie Person muss nun ein entsprechendes Schild mit dem Hinweis auf diese Auktion aufstellen.");
        break;
      case "mie":
      case "mietregion":
      case "mietzone":
      case "werbetafel":
        doAuction(mieTexte);
        addon.playerUtils.displayPrefix("§aDie Person muss nun ein entsprechendes Schild mit dem Hinweis auf diese Auktion aufstellen.");
        break;
      case "vehicle":
      case "auto":
      case "car":
      case "motorrad":
      case "mofa":
      case "heli":
      case "helikopter":
        doAuction(autoTexte);
        addon.playerUtils.displayPrefix("§aDie Person muss dir noch einen Schlüssel geben.");
        break;
      case "biz":
        doAuction(bizTexte);
        break;
      case "rechner":
      case "r":
      case "calc":
        if(message.length == 1) {
          addon.playerUtils.displayPrefix("§cBitte gib einen Betrag an: /auktion r <Betrag>");
          break;
        }

        NumberFormat format;
        if(message[1].contains(","))
          format = NumberFormat.getInstance(Locale.GERMAN);
        else
          format = NumberFormat.getInstance(Locale.ENGLISH);

        try {
          Number number = format.parse(message[1]);
          double d = number.doubleValue();

          double d97 = d * 0.97;
          double d03 = d - d97;

          NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
          nf.setGroupingUsed(true);
          nf.setMinimumFractionDigits(2);
          nf.setMaximumFractionDigits(2);

          addon.playerUtils.displayPrefix("§aAuktionsrechner");
          addon.playerUtils.displayPrefix("§aKunde erhält: " + nf.format(d97) + " Euro");
          addon.playerUtils.clickableCommand("§aFraktionskasse: " + nf.format(d03) + " Euro", "/feinzahlen", true);
          addon.playerUtils.displayPrefix("§aGesamt: " + nf.format(d) + " Euro");

        } catch (Exception ex) {
          addon.playerUtils.displayPrefix("§cBitte gib einen Betrag an: /auktion r <Betrag>");
        }
        break;
      default:
        addon.playerUtils.displayPrefix("§cKorrekte Anwendung: §e/auktion [item, code, gs, mie, auto, rechner]");
        break;
    }
  }
}
