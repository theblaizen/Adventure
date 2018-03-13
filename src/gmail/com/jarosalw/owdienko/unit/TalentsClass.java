package gmail.com.jarosalw.owdienko.unit;

import gmail.com.jarosalw.owdienko.unit.talents.mag.MagTalents;
import gmail.com.jarosalw.owdienko.unit.talents.rogue.RogueTalents;
import gmail.com.jarosalw.owdienko.unit.talents.warrior.WarriorTalents;

public enum TalentsClass {
    MAG(MagTalents.class.getName()),
    WARRIOR(WarriorTalents.class.getName()),
    ROGUE(RogueTalents.class.getName());

    private String talentsClassName;

    TalentsClass(String talentsClassName) {
        this.talentsClassName = talentsClassName;
    }

    public String getTalentsClassName() {
        return talentsClassName;
    }
}
