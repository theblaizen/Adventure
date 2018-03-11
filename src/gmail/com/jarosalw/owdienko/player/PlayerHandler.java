package gmail.com.jarosalw.owdienko.player;

import gmail.com.jarosalw.owdienko.player.enums.HeroClass;
import gmail.com.jarosalw.owdienko.player.enums.PlayerAttackMethod;
import gmail.com.jarosalw.owdienko.player.enums.PlayerStatus;

public class PlayerHandler {
    private Player player;
    private PlayerStatus playerStatus;
    private PlayerAttackMethod playerAttackMethod;

    public PlayerHandler(Player player) {
        this.player = player;
        this.playerStatus = PlayerStatus.REST;

        setupAttackMethod();
    }

    private void setupAttackMethod() {
        if ( player.getHeroClass() == HeroClass.MAG ) {
            playerAttackMethod = PlayerAttackMethod.MAGIC;
        } else {
            playerAttackMethod = PlayerAttackMethod.WEAPON;
        }
    }

    public void playerAttack() {
        if ( playerAttackMethod == null || !isPlayerNotDead() ) return;

        //TODO: define attacks
        switch ( playerAttackMethod ) {
            case WEAPON:
                break;
            case MAGIC:
                break;
        }
    }

    public void playerSay(String message) {
        if ( isPlayerNotDead() ) System.out.println("<" + player.getName() + "> " + message);
    }

    public void getPlayerStats() {
        if ( isPlayerNotDead() ) printStats(player.getHeroClass());
    }

    private void printStats(HeroClass heroClass) {
        String mDmg = null;
        String pDmg = null;
        String attackBooster = null;

        switch ( heroClass ) {
            case MAG:
                mDmg = String.valueOf(player.getMagicalDamage());
                pDmg = String.valueOf(player.getPhysicalDamage());
                attackBooster = String.valueOf(player.getWeapon().getWeaponStats().getAttackBooster());
                break;
            case WARRIOR:
                pDmg = String.valueOf(player.getPhysicalDamage());
                attackBooster = String.valueOf(player.getWeapon().getWeaponStats().getAttackBooster());
                break;
            case ROGUE:
                pDmg = String.valueOf(player.getPhysicalDamage());
                attackBooster = String.valueOf(player.getWeapon().getWeaponStats().getAttackBooster());
                break;
        }

        if ( mDmg != null ) {
            System.out.println("<["
                    + player.getHeroClass().getShortClassType() + "]" + player.getName() + "> "
                    + "HP:[" + player.getHp() + "] "
                    + "MP:[" + player.getMana() + "] "
                    + "DMG:[P" + pDmg + "/M" + mDmg + "+" + attackBooster + "] "
                    + "Money:[" + player.getMoney() + "] "
            );
        } else {
            System.out.println("<["
                    + player.getHeroClass().getShortClassType() + "]" + player.getName() + "> "
                    + "HP:[" + player.getHp() + "] "
                    + "MP:[" + player.getMana() + "] "
                    + "DMG:[P" + pDmg + "+" + attackBooster + "] "
                    + "Money:[" + player.getMoney() + "] "
            );
        }
    }

    public void changePlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void changePlayerAttackMethod(PlayerAttackMethod playerAttackMethod) {
        this.playerAttackMethod = playerAttackMethod;
    }

    public boolean isPlayerNotDead() {
        return !(playerStatus == PlayerStatus.DIED);
    }
}
