package com.darktroll.portalwars.listeners;

import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;
import com.darktroll.portalwars.managers.GameManager;
import com.darktroll.portalwars.managers.PlayerManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {

    private final GameManager gameManager = GameManager.getInstance();
    private final PlayerManager playerManager = PlayerManager.getInstance();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        GamePlayer player = playerManager.findGamePlayerByPlayer(event.getPlayer());

        if(player.getState() == GamePlayer.PlayerState.IN_GAME) {
            Game game = gameManager.findGameByGamePlayer(player);
            if(event.getBlock().getType() == Material.OBSIDIAN) {
                event.getPlayer().sendMessage("Вы сломали обсидиан в игре " + game.getWorld().getName());
            }
        } else {
            // ...
        }
    }

}
