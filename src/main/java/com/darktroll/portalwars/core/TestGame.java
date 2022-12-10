package com.darktroll.portalwars.core;

import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.data.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestGame {
    private int minPlayers;
    private int maxPlayers;
    private World world;
    private List<Location> spawnPoints = new ArrayList<>();
    private List<GamePlayer> players = new ArrayList<>();

    public TestGame(String gameName) {
        Configuration configuration = PortalWars.getInstance().getConfig();
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
        if (players.isEmpty()) {
            players.add(player);
            return true;
        } else if(players.size() < maxPlayers) {
            players.add(player);
            return true;
        } else {
            return false;
        }
    }

    public void startGame() {
        for (int i = 0; i < players.size(); i++) {
            GamePlayer player = players.get(i);
            Location point = spawnPoints.get(i);

            player.getPlayer().teleport(point);
        }
    }

}
