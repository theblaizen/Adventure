package gmail.com.jarosalw.owdienko.unit.weapons;

public class BaseWeapon implements BaseWeaponListener {
    private WeaponStats weaponStats;

    public BaseWeapon() {
    }

    public BaseWeapon(WeaponStats weaponStats) {
        this.weaponStats = weaponStats;
    }

    @Override
    public void decreaseDurability(int amount) {
        if ( weaponStats != null ) weaponStats.setDurability(weaponStats.getDurability() - amount);
    }

    @Override
    public void increaseDurability(int amount) {
        if ( weaponStats != null ) weaponStats.setDurability(weaponStats.getDurability() + amount);
    }

    @Override
    public void upgradeWeapon(int attackBooster, int durability, int level) {
        if ( weaponStats != null
                && weaponStats.getWeaponLevel() <= level
                && weaponStats.getMaxWeaponLevel() >= level ) {
            weaponStats.setAttackBooster(weaponStats.getAttackBooster() + attackBooster);
            weaponStats.setDurability(weaponStats.getDurability() + durability);
            weaponStats.setWeaponLevel(level);
        }
    }

    public void setWeaponStats(WeaponStats weaponStats) {
        this.weaponStats = weaponStats;
    }

    public WeaponStats getWeaponStats() {
        return weaponStats;
    }
}
