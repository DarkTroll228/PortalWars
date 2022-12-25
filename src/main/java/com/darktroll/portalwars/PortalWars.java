package com.darktroll.portalwars;

import co.aikar.commands.BukkitCommandManager;
import com.darktroll.portalwars.commands.InviteCommands;
import com.darktroll.portalwars.data.ConfigHandler;
import com.darktroll.portalwars.listeners.BlockListener;
import com.darktroll.portalwars.listeners.PlayerJoinListener;
import com.darktroll.portalwars.listeners.PlayerLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PortalWars extends JavaPlugin {
    private static PortalWars instance;


    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        ConfigHandler.getInstance().saveConfigFile();
        
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new InviteCommands());
        
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);

    }

    @Override
    public void onDisable() {
        instance = null;

    }

    public static PortalWars getInstance() {
        return instance;
    }

}
