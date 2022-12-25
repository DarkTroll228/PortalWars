package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.core.GamePlayer;
import com.darktroll.portalwars.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final PlayerManager playerManager = PlayerManager.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        GamePlayer player = new GamePlayer(event.getPlayer());
        playerManager.addPlayer(player);

        event.getPlayer().sendMessage("Добро пожаловать на сервер");
    }
}
