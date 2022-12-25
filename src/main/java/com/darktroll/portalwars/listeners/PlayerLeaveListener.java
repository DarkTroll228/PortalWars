package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.core.GamePlayer;
import com.darktroll.portalwars.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    private final PlayerManager playerManager = PlayerManager.getInstance();

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        GamePlayer player = playerManager.findGamePlayerByPlayer(event.getPlayer());
        playerManager.removePlayer(player);
    }
}
