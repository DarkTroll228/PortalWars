package com.darktroll.portalwars;

import co.aikar.commands.BukkitCommandManager;
import com.darktroll.portalwars.commands.InviteCommands;
import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PortalWars extends JavaPlugin {
    private static PortalWars instance;
    private List<Game> gameList = new ArrayList<>();
    private List<GamePlayer> players = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new InviteCommands());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static PortalWars getInstance() {
        return instance;
    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }
}
