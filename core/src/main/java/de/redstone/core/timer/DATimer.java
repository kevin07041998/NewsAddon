package de.redstone.core.timer;

import de.redstone.core.NewsAddon;
import de.redstone.core.utils.PlayerUtils;
import net.labymod.api.Laby;
import net.labymod.api.client.resources.ResourceLocation;

import java.util.TimerTask;

public class DATimer extends TimerTask {
    NewsAddon newsAddon;

    public DATimer(NewsAddon newsAddon) {
        this.newsAddon = newsAddon;
    }

    @Override
    public void run() {
        try {
            if (newsAddon.DEBUGMODE || Laby.labyAPI().serverController().getCurrentServerData().address().toString().toLowerCase().contains("germanminer")) {
                PlayerUtils pUtils = new PlayerUtils(newsAddon);
                pUtils.displayPrefix("§a§lEventuell muss ein Dauerauftrag geschaltet werden!");

                Laby.labyAPI().minecraft().sounds().playSound(ResourceLocation.create("minecraft", "toast.challenge.complete"), 1.0F, 1.0F);
            }
        } catch (NullPointerException ex) {
            System.out.println("[NEWS-DEBUG] NullPointerException at DauerauftragTimer");
        }
    }
}