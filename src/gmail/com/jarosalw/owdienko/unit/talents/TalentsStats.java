package gmail.com.jarosalw.owdienko.unit.talents;

public class TalentsStats {
    private String talentName;
    private int level;
    private int maxLevel;
    private int damage;
    private int manaUsage;
    private boolean hasAreaDamage;
    private TalentType talentType;
    private double talentRuntime;
    private double castTime;

    public TalentsStats(TalentsBuilder builder) {
        talentName = builder.talentName;
        level = builder.level;
        maxLevel = builder.maxLevel;
        damage = builder.damage;
        manaUsage = builder.manaUsage;
        hasAreaDamage = builder.hasAreaDamage;
        talentType = builder.talentType;
        talentRuntime = builder.talentRuntime;
        castTime = builder.castTime;
    }

    public String getTalentName() {
        return talentName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaUsage() {
        return manaUsage;
    }

    public void setManaUsage(int manaUsage) {
        this.manaUsage = manaUsage;
    }

    public boolean isHasAreaDamage() {
        return hasAreaDamage;
    }

    public TalentType getTalentType() {
        return talentType;
    }

    public double getTalentRuntime() {
        return talentRuntime;
    }

    public void setTalentRuntime(double talentRuntime) {
        this.talentRuntime = talentRuntime;
    }

    public double getCastTime() {
        return castTime;
    }

    public void setCastTime(double castTime) {
        this.castTime = castTime;
    }

    public static class TalentsBuilder {
        private final String talentName;
        private final TalentType talentType;
        private final boolean hasAreaDamage;
        private final int maxLevel;
        private int level = 1;
        private int damage;
        private int manaUsage;
        private double talentRuntime = 0;
        private double castTime = 0;

        public TalentsBuilder(String talentName, TalentType talentType, boolean hasAreaDamage, int maxLevel) {
            this.talentName = talentName;
            this.talentType = talentType;
            this.hasAreaDamage = hasAreaDamage;
            this.maxLevel = maxLevel;
        }

        public TalentsBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public TalentsBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public TalentsBuilder setManaUsage(int manaUsage) {
            this.manaUsage = manaUsage;
            return this;
        }

        public TalentsBuilder setTalentRuntime(double talentRuntime) {
            this.talentRuntime = talentRuntime;
            return this;
        }

        public TalentsBuilder setCastTime(double castTime) {
            this.castTime = castTime;
            return this;
        }

        public TalentsStats create() {
            return new TalentsStats(this);
        }
    }
}
