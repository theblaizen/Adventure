package gmail.com.jarosalw.owdienko.unit.weapons;

import gmail.com.jarosalw.owdienko.unit.weapons.mag.StartScepter;
import gmail.com.jarosalw.owdienko.unit.weapons.rogue.StartKnife;
import gmail.com.jarosalw.owdienko.unit.weapons.warrior.StartSword;

public enum InitializeWeapon {
    BASIC_WEAPON_MAG(StartScepter.class.getName()),
    BASIC_WEAPON_WARRIOR(StartSword.class.getName()),
    BASIC_WEAPON_ROGUE(StartKnife.class.getName());

    private String weaponClass;

    InitializeWeapon(String weaponClass) {
        this.weaponClass = weaponClass;
    }

    public String getWeaponClass() {
        return weaponClass;
    }
}
