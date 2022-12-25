package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.data.GameRegisterHandler;
import com.darktroll.portalwars.managers.GameManager;
import com.darktroll.portalwars.managers.PlayerManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

import java.io.File;

public class PluginDisableListener implements Listener {

    private PortalWars portalWars = PortalWars.getInstance();
    private GameManager gameManager = GameManager.getInstance();
    private GameRegisterHandler registerHandler = GameRegisterHandler.getInstance();

    @EventHandler
    public void onDisable(PluginDisableEvent event) {
        // TODO save all games in file
    }

}
