package gmail.com.jarosalw.owdienko;

import gmail.com.jarosalw.owdienko.player.Player;
import gmail.com.jarosalw.owdienko.player.PlayerHandler;
import gmail.com.jarosalw.owdienko.player.enums.HeroClass;

public class Main {

    public static void main(String[] args) {
        initPlayer();

//        while ( true ) {
//
//        }

    }

    private static void initPlayer() {
        //TODO: let user choose
        Player player = new Player.PlayerBuilder("Kabz", HeroClass.MAG).create();
        PlayerHandler playerHandler = new PlayerHandler(player);

        playerHandler.getPlayerStats();
        playerHandler.playerSay("Hi!");
    }
}
