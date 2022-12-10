package com.darktroll.portalwars.managers;

import com.darktroll.portalwars.core.GamePlayer;

import java.util.ArrayList;
import java.util.List;

public final class PlayerManager {
    private PlayerManager instance = new PlayerManager();
    private List<GamePlayer> players = new ArrayList<>();

    private PlayerManager() {

    }

    public PlayerManager getInstance() {
        return instance;
    }
}
