package gmail.com.jarosalw.owdienko.player.enums;

public enum HeroClass {
    MAG("MAG", "MAG"),
    WARRIOR("WARRIOR", "WAR"),
    ROGUE("ROGUE", "ROG");

    private String classType;
    private String shortClassType;

    HeroClass(String classType, String shortClassType) {
        this.classType = classType;
        this.shortClassType = shortClassType;
    }

    public static HeroClass findByTypeName(String classType) {
        for ( HeroClass item : HeroClass.values() ) {
            if ( item.getClassType().equalsIgnoreCase(classType) ) return item;
        }
        return null;
    }

    public static HeroClass findByShortTypeName(String classType) {
        for ( HeroClass item : HeroClass.values() ) {
            if ( item.getShortClassType().equalsIgnoreCase(classType) ) return item;
        }
        return null;
    }

    public String getClassType() {
        return classType;
    }

    public String getShortClassType() {
        return shortClassType;
    }
}
