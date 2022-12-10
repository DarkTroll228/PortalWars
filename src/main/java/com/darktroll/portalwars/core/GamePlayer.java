package com.darktroll.portalwars.core;

import com.darktroll.portalwars.PortalWars;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class GamePlayer {

    private Player player;
    private PlayerState state = PlayerState.NOT_IN_GAME;

    public GamePlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public enum PlayerState {
        NOT_IN_GAME, WAITING, PREPARATION, IN_GAME, ENDING
    }
}
