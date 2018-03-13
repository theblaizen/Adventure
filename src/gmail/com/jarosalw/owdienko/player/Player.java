package gmail.com.jarosalw.owdienko.player;

import gmail.com.jarosalw.owdienko.player.enums.HeroClass;
import gmail.com.jarosalw.owdienko.unit.TalentsClass;
import gmail.com.jarosalw.owdienko.unit.talents.BaseTalents;
import gmail.com.jarosalw.owdienko.unit.talents.mag.MagTalents;
import gmail.com.jarosalw.owdienko.unit.talents.rogue.RogueTalents;
import gmail.com.jarosalw.owdienko.unit.talents.warrior.WarriorTalents;
import gmail.com.jarosalw.owdienko.unit.weapons.BaseWeapon;
import gmail.com.jarosalw.owdienko.unit.weapons.InitializeWeapon;
import gmail.com.jarosalw.owdienko.unit.weapons.WeaponStats;

public class Player {
    private static final int DEFAULT_MAG_HP = 10;
    private static final int DEFAULT_WARRIOR_HP = 17;
    private static final int DEFAULT_ROGUE_HP = 13;

    private static final int DEFAULT_MAG_MP = 35;
    private static final int DEFAULT_WARRIOR_MP = 0;
    private static final int DEFAULT_ROGUE_MP = 100;

    private static final int DEFAULT_MAG_DMG_P = 1;
    private static final int DEFAULT_MAG_DMG_M = 6;
    private static final int DEFAULT_WARRIOR_DMG_P = 3;
    private static final int DEFAULT_ROGUE_DMG_P = 2;

    private String name;
    private int hp;
    private int mana;
    private int money;
    private int magicalDamage;
    private int physicalDamage;
    private HeroClass heroClass;
    private BaseWeapon weapon;
    private InitializeWeapon initializeWeapon;
    private BaseTalents talents;

    public Player(PlayerBuilder builder) {
        name = builder.name;
        hp = builder.hp;
        mana = builder.mana;
        money = builder.money;
        magicalDamage = builder.magicalDamage;
        physicalDamage = builder.physicalDamage;
        heroClass = builder.heroClass;
        weapon = builder.weapon;
        initializeWeapon = builder.initializeWeapon;
        talents = builder.talents;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public int getMagicalDamage() {
        return magicalDamage;
    }

    public void setMagicalDamage(int magicalDamage) {
        this.magicalDamage = magicalDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public BaseWeapon getWeapon() {
        return weapon;
    }

    public InitializeWeapon getInitializeWeapon() {
        return initializeWeapon;
    }

    public void setInitializeWeapon(InitializeWeapon initializeWeapon) {
        this.initializeWeapon = initializeWeapon;
    }

    public <T extends BaseWeapon> void setWeapon(T weapon) {
        this.weapon = weapon;
    }

    public BaseTalents getTalents() {
        return talents;
    }

    public <T extends BaseTalents> void setTalents(T talents) {
        this.talents = talents;
    }

    public static class PlayerBuilder {
        private final String name;
        private final HeroClass heroClass;

        private int hp;
        private int mana;
        private int magicalDamage;
        private int physicalDamage;
        private int money = 230;
        private BaseWeapon weapon;
        private InitializeWeapon initializeWeapon;
        private BaseTalents talents;

        public PlayerBuilder(String name, HeroClass heroClass) {
            this.name = name;
            this.heroClass = heroClass;

            setupDefaultHero();
        }

        public PlayerBuilder setHp(int hp) {
            this.hp = hp;
            return this;
        }

        public PlayerBuilder setMana(int mana) {
            this.mana = mana;
            return this;
        }

        public PlayerBuilder setMoney(int money) {
            this.money = money;
            return this;
        }

        public PlayerBuilder setMagicalDamage(int magicalDamage) {
            this.magicalDamage = magicalDamage;
            return this;
        }

        public PlayerBuilder setPhysicalDamage(int physicalDamage) {
            this.physicalDamage = physicalDamage;
            return this;
        }

        public <T extends BaseWeapon> PlayerBuilder setWeapon(T weapon) {
            this.weapon = weapon;
            return this;
        }

        public PlayerBuilder setInitializeWeapon(InitializeWeapon initializeWeapon) {
            this.initializeWeapon = initializeWeapon;
            return this;
        }

        public <T extends BaseTalents> void setTalents(T talents) {
            this.talents = talents;
        }

        private void setupDefaultHero() {
            WeaponStats basicWeaponStats = null;
            try {
                switch ( this.heroClass ) {
                    case MAG:
                        initializeWeapon = InitializeWeapon.BASIC_WEAPON_MAG;
                        setupDefaults(DEFAULT_MAG_HP, DEFAULT_MAG_MP, DEFAULT_MAG_DMG_P, DEFAULT_MAG_DMG_M);
                        basicWeaponStats = new WeaponStats.WeaponBuilder("Student Scepter", 1)
                                .setAttackBooster(1)
                                .setWeaponLevel(1)
                                .setDurability(10)
                                .setCurrentDurability(10)
                                .create();
                        talents = (MagTalents) Class.forName(TalentsClass.MAG.getTalentsClassName()).newInstance();
                        talents.setTalentsClass(TalentsClass.MAG);
                        talents.initBaseTalents();
                        break;
                    case WARRIOR:
                        initializeWeapon = InitializeWeapon.BASIC_WEAPON_WARRIOR;
                        setupDefaults(DEFAULT_WARRIOR_HP, DEFAULT_WARRIOR_MP, DEFAULT_WARRIOR_DMG_P);
                        basicWeaponStats = new WeaponStats.WeaponBuilder("Student Sword", 1)
                                .setAttackBooster(1)
                                .setWeaponLevel(1)
                                .setDurability(10)
                                .setCurrentDurability(10)
                                .create();
                        talents = (WarriorTalents) Class.forName(TalentsClass.WARRIOR.getTalentsClassName()).newInstance();
                        talents.setTalentsClass(TalentsClass.WARRIOR);
                        talents.initBaseTalents();
                        break;
                    case ROGUE:
                        initializeWeapon = InitializeWeapon.BASIC_WEAPON_ROGUE;
                        setupDefaults(DEFAULT_ROGUE_HP, DEFAULT_ROGUE_MP, DEFAULT_ROGUE_DMG_P);
                        basicWeaponStats = new WeaponStats.WeaponBuilder("Student Knife", 1)
                                .setAttackBooster(1)
                                .setWeaponLevel(1)
                                .setDurability(10)
                                .setCurrentDurability(10)
                                .create();
                        talents = (RogueTalents) Class.forName(TalentsClass.ROGUE.getTalentsClassName()).newInstance();
                        talents.setTalentsClass(TalentsClass.ROGUE);
                        talents.initBaseTalents();
                        break;
                }
                weapon = (BaseWeapon) Class.forName(initializeWeapon.getWeaponClass()).newInstance();
                weapon.setWeaponStats(basicWeaponStats);
            } catch ( Exception err ) {
                err.printStackTrace();
            }
        }

        /**
         * Order: HP, MP, P_DMG, M_DMG
         *
         * @param stats array with default stats
         */
        private void setupDefaults(int... stats) throws Exception {
            if ( stats.length == 0 ) throw new Exception("Array with default stats can not be empty!");
            else if ( stats.length < 3 ) throw new Exception("Array must contain at least 3 items!");

            this.hp = stats[0];
            this.mana = stats[1];
            this.physicalDamage = stats[2];
            if ( stats.length > 3 ) this.magicalDamage = stats[3];
        }

        public Player create() {
            return new Player(this);
        }
    }
}
