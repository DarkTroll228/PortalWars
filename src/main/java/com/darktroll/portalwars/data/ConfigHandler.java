package com.darktroll.portalwars.data;

import com.darktroll.portalwars.PortalWars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigHandler {

    private static ConfigHandler instance = new ConfigHandler();
    private File gameInfoFile;
    private FileConfiguration gameInfo;

    private ConfigHandler() {
        this.gameInfoFile = new File(PortalWars.getInstance().getDataFolder(), "gameInfo.yml");
        if(!this.gameInfoFile.exists()){
            try {
                this.gameInfoFile.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        this.gameInfo = YamlConfiguration.loadConfiguration(this.gameInfoFile);
    }

    public void saveGameInfo() {
        try {
            this.gameInfo.save(this.gameInfoFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConfigHandler getInstance() {
        return instance;
    }

    public FileConfiguration getGameInfo() {
        return gameInfo;
    }
}
