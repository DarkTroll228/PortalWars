package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.PortalWars;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    private PortalWars plugin = PortalWars.getInstance();

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        // TODO Removing a player from the list
    }
}
