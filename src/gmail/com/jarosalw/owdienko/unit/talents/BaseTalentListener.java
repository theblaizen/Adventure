package gmail.com.jarosalw.owdienko.unit.talents;

import gmail.com.jarosalw.owdienko.unit.TalentsClass;

import java.util.List;
import java.util.Map;

public interface BaseTalentListener {
    void increaseTalentLevel(TalentType talentType, TalentsStats talentsStats);

    TalentsClass getTalentClass();

    Map<TalentType, List<TalentsStats>> getTalentsList();
}
