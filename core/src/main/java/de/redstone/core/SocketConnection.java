package de.redstone.core;

import de.redstone.core.timer.DATimer;
import de.redstone.core.utils.PlayerUtils;
import net.labymod.api.Laby;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

public class SocketConnection extends WebSocketClient {
    public static SocketConnection socket;
    public PlayerUtils pUtils;
    public String token = "";
    public boolean authenticated = false;
    private final NewsAddon newsAddon;

    public SocketConnection(URI serverUri, NewsAddon newsAddon) {
        super(serverUri);
        pUtils = new PlayerUtils(newsAddon);
        this.newsAddon = newsAddon;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        pUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Du bist nun verbunden!");
        this.authenticate(Laby.labyAPI().minecraft().sessionAccessor().getSession().getAccessToken(), Laby.labyAPI().minecraft().getClientPlayer().getUniqueId().toString().replace("-", ""));
    }

    @Override
    public void onMessage(String s) {
        if (s.startsWith("authSuccess")) {
            socket.token = s.split(" ")[1];
            socket.authenticated = true;

            socket.s("da giveMeAllThousandTimedAdvertisements");

        } else if (s.startsWith("nf ")) {
            String user = s.split(" ")[1];
            String message = s.replace("nf " + user + " ", "");
            pUtils.displayNormal("§c§l[N-CHAT] §a" + user + " §7»§f " + message);
        } else if (s.startsWith("noNewsler")) {
            pUtils.displayPrefix("§cDa du kein Newsler bist, wird das Addon nun automatisch deinstalliert!");
            pUtils.displayPrefix("§cFalls es sich dabei um einen Fehler handelt, wende dich bitte an Jan.");
            pUtils.displayPrefix("§fDanke für die Verwendung des News-Addons <3");

            //UpdateChecker.initialize(Integer.MAX_VALUE);

        /*} else if (s.startsWith("pm ")) {
            String from = s.split(" ")[1];
            String to = s.split(" ")[2];
            String message = s.replace("pm " + from + " " + to + " ", "");

            newsAddon.lastContact = (from.equalsIgnoreCase(LabyMod.getInstance().getPlayerName()) ? to : from);

            if (to.equalsIgnoreCase(LabyMod.getInstance().getPlayerName()))
                to = "mir";
            if(from.equalsIgnoreCase(LabyMod.getInstance().getPlayerName()))
                from = "mir";

            pUtils.displayNormal("§c§l[N-PM] §a" + from + " §7> §c" + to + " §7»§f " + message);*/

        } else if (s.startsWith("versionCheck")) {
            this.s("myVersion " + NewsAddon.VERSION);
        } else if (s.startsWith("currentServer")) {
            this.s("myServer " + Laby.labyAPI().serverController().getCurrentServerData().address().toString());
        } else if (s.startsWith("registerDA ")) {
            String[] args = s.split(" ");
            if (args.length < 1)
                return;
            String time = args[1];

            try {
                DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = createDate() + " " + time + ":00";
                Date date = dateFormatter.parse(dateString);

                if (!newsAddon.das.contains(dateString)) {
                    Timer daTimer = new Timer();
                    daTimer.schedule(new DATimer(newsAddon), date);

                    newsAddon.das.add(dateString);
                    System.out.println("[NEWS-DEBUG] registered DA at " + dateString);
                }
            } catch (Exception ignored) {
            }
        } else if (s.startsWith("playsound ") && s.toLowerCase().endsWith(".wav")) {
            //PlaySound.play(s.replace("playsound ", ""));
        } else if (s.startsWith("stopsound")) {
            //PlaySound.d.stop();
            //TODO PlaySound.d = null;
        } else {
            System.out.println("[NEWS-WS] Unknown msg: " + s);
        }

    }

    @Override
    public void onClose(int i, String s, boolean b) {
        pUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Verbindung zum Server getrennt.");

        // 1006 = server offline gegangen
        if (i == 1006)
            newsAddon.ws_timeout = true;

        socket = null;
    }

    @Override
    public void onError(Exception e) {
        socket = null;
        pUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Ich konnte dich nicht mit dem Server verbinden. Versuche es später noch einmal mit /nf connect");

    }

    public void authenticate(String accessToken, String selectedProfile) {

        socket.send("plsAuthMe " + accessToken + " " + selectedProfile);

    }

    public void s(String msg) {
        if (socket.authenticated) {
            try {
                socket.send(msg.replace("§TOKEN§", socket.token));
            } catch (WebsocketNotConnectedException ex) {
                pUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Du bist nicht mit dem Server verbunden!");
                socket.connectSocket();
            }
        }
    }

    public void connectSocket() {
        if (socket != null)
            return;
        try {
            socket = new SocketConnection(new URI(newsAddon.ws), newsAddon);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        PlayerUtils pUtils = new PlayerUtils(newsAddon);
        pUtils.displayNormal("§c§l[N-CHAT] §a§oPeppi §7»§f§o Ich verbinde dich mit dem Server...");
        socket.connect();
    }

    private String createDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}