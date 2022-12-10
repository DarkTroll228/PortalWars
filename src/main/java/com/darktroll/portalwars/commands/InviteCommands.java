package com.darktroll.portalwars.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import com.darktroll.portalwars.PortalWars;
import com.darktroll.portalwars.core.Game;
import com.darktroll.portalwars.core.GamePlayer;
import com.darktroll.portalwars.core.TestGame;
import org.bukkit.entity.Player;

@CommandAlias("war")
public class InviteCommands extends BaseCommand {

    @Subcommand("join")
    public void onJoin(Player player, String[] args) {
        if(args.length == 0) {

        }else {
            Game game = new Game(args[0]);
            PortalWars.getInstance().addGame(game);

            GamePlayer gamePlayer = new GamePlayer(player);
            game.registerPlayer(gamePlayer);
            game.startGame();
        }
    }

    @Subcommand("invite")
    public void onInvite(Player player, String[] args) {

    }

}
