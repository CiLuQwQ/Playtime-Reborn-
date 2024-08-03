package github.CiLuQwQ.playtime.client;

import net.fabricmc.api.ClientModInitializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlaytimeClient implements ClientModInitializer {
    public static LocalDateTime date_started = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Override
    public void onInitializeClient() {

    }
}
