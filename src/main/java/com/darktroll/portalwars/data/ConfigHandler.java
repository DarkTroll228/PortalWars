package com.darktroll.portalwars.data;

import com.darktroll.portalwars.PortalWars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigHandler extends DataHandler{

    private static ConfigHandler instance = new ConfigHandler("gameInfo.yml");

    private ConfigHandler(String child) {
        super(child);
    }

    public static ConfigHandler getInstance() {
        return instance;
    }

}
