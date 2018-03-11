package gmail.com.jarosalw.owdienko.unit.weapons;

public class WeaponStats {
    private String weaponName;
    private int durability;
    private int currentDurability;
    private int attackBooster;
    private int weaponLevel;
    private int maxWeaponLevel;

    public WeaponStats(WeaponBuilder builder) {
        this.weaponName = builder.weaponName;
        this.durability = builder.durability;
        this.currentDurability = builder.currentDurability;
        this.attackBooster = builder.attackBooster;
        this.weaponLevel = builder.weaponLevel;
        this.maxWeaponLevel = builder.maxWeaponLevel;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getCurrentDurability() {
        return currentDurability;
    }

    public void setCurrentDurability(int currentDurability) {
        this.currentDurability = currentDurability;
    }

    public int getAttackBooster() {
        return attackBooster;
    }

    public void setAttackBooster(int attackBooster) {
        this.attackBooster = attackBooster;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    public int getMaxWeaponLevel() {
        return maxWeaponLevel;
    }

    public void setMaxWeaponLevel(int maxWeaponLevel) {
        this.maxWeaponLevel = maxWeaponLevel;
    }

    public static class WeaponBuilder {
        private final String weaponName;
        private int durability;
        private int currentDurability;
        private int attackBooster;
        private int weaponLevel;
        private final int maxWeaponLevel;

        public WeaponBuilder(String weaponName, int maxWeaponLevel) {
            this.weaponName = weaponName;
            this.maxWeaponLevel = maxWeaponLevel;
        }

        public WeaponBuilder setDurability(int durability) {
            this.durability = durability;
            return this;
        }

        public WeaponBuilder setCurrentDurability(int currentDurability) {
            this.currentDurability = currentDurability;
            return this;
        }

        public WeaponBuilder setAttackBooster(int attackBooster) {
            this.attackBooster = attackBooster;
            return this;
        }

        public WeaponBuilder setWeaponLevel(int weaponLevel) {
            this.weaponLevel = weaponLevel;
            return this;
        }

        public WeaponStats create() {
            return new WeaponStats(this);
        }
    }
}
