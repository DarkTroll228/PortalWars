package com.darktroll.portalwars.managers;

import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GameManager {
    private static GameManager instance = new GameManager();
    private List<Game> games = new ArrayList<>();

    private GameManager() {

    }

    public static GameManager getInstance() {
        return instance;
    }

    public Game findGameByGamePlayer(GamePlayer player) {
        for (Game game : games) {
            for (GamePlayer gamePlayer : game.getPlayers()) {
                if(gamePlayer == player) {
                    return game;
                }
            }
        }
        return null;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public List<Game> getGames() {
        return games;
    }
}
