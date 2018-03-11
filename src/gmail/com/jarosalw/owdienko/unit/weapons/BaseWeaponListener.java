package gmail.com.jarosalw.owdienko.unit.weapons;

public interface BaseWeaponListener {
    void decreaseDurability(int amount);

    void increaseDurability(int amount);

    void upgradeWeapon(int attackBooster, int durability, int level);
}
