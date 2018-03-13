package gmail.com.jarosalw.owdienko.unit.talents;

import gmail.com.jarosalw.owdienko.unit.TalentsClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTalents implements BaseTalentListener {
    private TalentsClass talentsClass;
    private Map<TalentType, List<TalentsStats>> talentsList;

    public BaseTalents() {
        this.talentsList = new HashMap<>();
    }

    public BaseTalents(TalentsClass talentsClass) {
        this.talentsClass = talentsClass;
        this.talentsList = new HashMap<>();
    }

    public void initBaseTalents() {
        List<TalentsStats> talentsStats = new ArrayList<>();

        switch ( talentsClass ) {
            case MAG:
                talentsStats.add(new TalentsStats.TalentsBuilder("Fire ball", TalentType.MAGICAL, false, 10)
                        .setDamage(3)
                        .setLevel(1)
                        .setManaUsage(10)
                        .setCastTime(1)
                        .create());
                talentsList.put(TalentType.MAGICAL, talentsStats);
                break;
            case WARRIOR:
                talentsStats.add(new TalentsStats.TalentsBuilder("Hero strike", TalentType.PHYSICAL, false, 10)
                        .setDamage(2)
                        .setLevel(1)
                        .setManaUsage(5)
                        .create());
                talentsList.put(TalentType.MAGICAL, talentsStats);
                break;
            case ROGUE:
                talentsStats.add(new TalentsStats.TalentsBuilder("Sinister strike", TalentType.PHYSICAL, false, 10)
                        .setDamage(2)
                        .setLevel(1)
                        .setManaUsage(5)
                        .create());
                talentsList.put(TalentType.MAGICAL, talentsStats);
                break;
        }
    }

    @Override
    public void increaseTalentLevel(TalentType talentType, TalentsStats talentsStats) {
        updateTalentsStats(talentType,talentsStats);
    }

    private void updateTalentsStats(TalentType talentType, TalentsStats talentsStats) {
        List<TalentsStats> localStats = talentsList.get(talentType);

        if ( localStats.contains(talentsStats) ){
            //todo update talents
        }

//        this.talentsStats.setDamage(talentsStats.getDamage());
//        this.talentsStats.setLevel(talentsStats.getLevel());
//        this.talentsStats.setManaUsage(talentsStats.getManaUsage());
    }

    @Override
    public TalentsClass getTalentClass() {
        return this.talentsClass;
    }

    @Override
    public Map<TalentType, List<TalentsStats>> getTalentsList() {
        return talentsList;
    }

    public void setTalentsList(Map<TalentType, List<TalentsStats>> talentsList) {
        this.talentsList = talentsList;
    }

    public void setTalentsClass(TalentsClass talentsClass) {
        this.talentsClass = talentsClass;
    }
}
