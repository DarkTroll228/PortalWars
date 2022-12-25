package com.darktroll.portalwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;
import com.darktroll.portalwars.core.TestGame;
import com.darktroll.portalwars.managers.GameManager;
import com.darktroll.portalwars.managers.PlayerManager;
import org.bukkit.entity.Player;

@CommandAlias("war")
public class InviteCommands extends BaseCommand {

    private final GameManager gameManager = GameManager.getInstance();
    private final PlayerManager playerManager = PlayerManager.getInstance();

    @Subcommand("join")
    public void onJoin(Player player, String[] args) {
        if(args.length == 0) {

        }else {
            Game game = new Game(args[0]);
            gameManager.addGame(game);

            GamePlayer gamePlayer = playerManager.findGamePlayerByPlayer(player);
            game.registerPlayer(gamePlayer);
            game.startGame();
        }
    }

    @Subcommand("invite")
    public void onInvite(Player player, String[] args) {

    }

}
