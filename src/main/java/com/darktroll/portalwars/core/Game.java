package com.darktroll.portalwars.core;

import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.data.ConfigHandler;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private PortalWars portalWars = PortalWars.getInstance();
    private final int minPlayers;
    private final int maxPlayers;
    private final World world;
    private GameState state = GameState.WAITING;
    private List<Location> spawnPoints = new ArrayList<>();
    private List<GamePlayer> players = new ArrayList<>();

    public Game(String gameName) {
        FileConfiguration configuration = ConfigHandler.getInstance().getConfigFile();
        this.minPlayers = configuration.getInt("games." + gameName + ".minPlayers");
        this.maxPlayers = configuration.getInt("games." + gameName + ".maxPlayers");
        this.world = Bukkit.createWorld(new WorldCreator(configuration.getString("games." + gameName + ".worldName") + "_active"));
        for(String point : configuration.getStringList("games." + gameName + ".spawnPoints")) {
            try{
                String[] values = point.split(",");
                double x = Double.parseDouble(values[0].split(":")[1]);
                double y = Double.parseDouble(values[1].split(":")[1]);
                double z = Double.parseDouble(values[2].split(":")[1]);
                Location location = new Location(world, x, y, z);
                spawnPoints.add(location);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean registerPlayer(GamePlayer player) {
        if(players.size() < maxPlayers) {
            players.add(player);
            return true;
        }
        if(players.size() >= minPlayers) {
            state = GameState.PREPARATION;
            return true;
        } else return false;
    }


    public void startGame() {
        for (int i = 0; i < players.size(); i++) {
            GamePlayer player = players.get(i);
            Location point = spawnPoints.get(i);
            player.setState(GamePlayer.PlayerState.IN_GAME);
            this.state = GameState.ACTIVE;

            player.getPlayer().teleport(point);
            player.getPlayer().getInventory().clear();
            player.getPlayer().setHealth(player.getPlayer().getMaxHealth());
            player.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
    }

    public enum GameState {
        WAITING, PREPARATION, ACTIVE, ENDING
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public World getWorld() {
        return world;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }

}
