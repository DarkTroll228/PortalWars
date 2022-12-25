package com.darktroll.portalwars.data;

import com.darktroll.portalwars.PortalWars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public abstract class DataHandler {
    private final File infoFile;
    private final FileConfiguration configFile;

    protected DataHandler(String child) {
        this.infoFile = new File(PortalWars.getInstance().getDataFolder(), child);
        if(!this.infoFile.exists()){
            try {
                this.infoFile.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.configFile = YamlConfiguration.loadConfiguration(this.infoFile);
    }

    public void saveConfigFile() {
        try {
            this.configFile.save(this.infoFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfigFile() {
        return configFile;
    }


}
