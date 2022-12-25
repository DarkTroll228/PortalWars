package com.darktroll.portalwars.managers;

import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public final class PlayerManager {
    private static PlayerManager instance = new PlayerManager();
    private List<GamePlayer> players = new ArrayList<>();

    private PlayerManager() {

    }

    public static PlayerManager getInstance() {
        return instance;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }

    public void addPlayer(GamePlayer player) {
        players.add(player);
    }

    public void removePlayer(GamePlayer player) {
        players.remove(player);
    }

    public GamePlayer findGamePlayerByPlayer(Player player) {
        for (GamePlayer gamePlayer : players) {
            if(gamePlayer.getPlayer() == player) {
                return gamePlayer;
            }
        }
        return null;
    }
}
