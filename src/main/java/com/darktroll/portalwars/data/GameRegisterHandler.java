package com.darktroll.portalwars.data;

public class GameRegisterHandler extends DataHandler{
    private static final GameRegisterHandler instance = new GameRegisterHandler("unregisterGames.yml");

    private GameRegisterHandler(String child) {
        super(child);
    }

    public static GameRegisterHandler getInstance() {
        return instance;
    }
}
