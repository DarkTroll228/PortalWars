package com.darktroll.portalwars.core;

import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.data.ConfigHandler;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    private int minPlayers;
    private int maxPlayers;
    private World world;
    private GameState state = GameState.WAITING;
    private List<Location> spawnPoints = new ArrayList<>();
    private List<GamePlayer> players = new ArrayList<>();

    public Game(String gameName) {
        FileConfiguration configuration = ConfigHandler.getInstance().getGameInfo();
        this.minPlayers = configuration.getInt("games." + gameName + ".minPlayers");
        this.maxPlayers = configuration.getInt("games." + gameName + ".maxPlayers");
        this.world = Bukkit.createWorld(new WorldCreator("games." + gameName + ".world"));
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
}
