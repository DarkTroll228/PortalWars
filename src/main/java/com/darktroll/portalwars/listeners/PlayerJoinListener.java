package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.core.GamePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    private PortalWars plugin = PortalWars.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        GamePlayer player = new GamePlayer(event.getPlayer());

        plugin.getPlayers().add(player);

        event.getPlayer().sendMessage("Добро пожаловать на сервер");
    }
}
