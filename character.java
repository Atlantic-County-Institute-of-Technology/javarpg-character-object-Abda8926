import java.util.*;

public class character {

    private String name;
    private String charType;
    private int level;
    private int hitPoints;
    private int armorClass;
    private int STR;
    private int DEX;
    private int INT;
    private int CON;
    private int WIS;
    private int CHA;
    public Dice dice = new Dice();


    public character(String name, String charType, int level) {
        this.name = name;
        this.charType = charType;
        this.level = level;
        this.hitPoints = 1;
        this.armorClass = 0;
        this.STR = 10;
        this.DEX = 10;
        this.INT = 10;
        this.CON = 10;
        this.WIS = 10;
        this.CHA = 10;
    }


    public int getAbilityModifier(int abScore){
        return (abScore - 10) / 2 ;
    }

    public int getPrimaryAbilityModifier() {
        if (charType == "melee") {
            return getAbilityModifier(STR);
        }
        if (charType == "ranged") {
            return getAbilityModifier(DEX);
        }
        if (charType == "magic") {
            return getAbilityModifier(INT);
        }
        else{
            return 0;
        }
    }

    public void calculateBaseHitPoints(){
        hitPoints = 20 + getAbilityModifier(CON);
    }

    public void calculateArmorClass(){
        armorClass = 20 + getAbilityModifier(getPrimaryAbilityModifier());
    }

    public int rollStat(){
        dice.addDice(4, 6);
        dice.rollAll();
        dice.sortDice();
        dice.removeDie(0);
        int val = dice.getAllValues();
        dice.clear();
        return val;
    }

    public void rollStats(){
        STR = rollStat();
        DEX = rollStat();
        CON = rollStat();
        INT = rollStat();
        WIS = rollStat();
        CHA = rollStat();
        calculateArmorClass();
        calculateBaseHitPoints();
    }


    public boolean isAlive(){
        return hitPoints > 0;
    }

    public String toString(){
        String chara = name.toUpperCase() + " " + "(Level " + level +" " + charType +")\n";
        chara += "HP: " + hitPoints + " | AC: " + armorClass + "\n";
        chara += "STR: " + STR + " | DEX: " + DEX + " | CON: " + CON +"\n";
        chara += "INT: " + INT + " | WIS: " + WIS + " | CHA: " + CHA;
        return chara;
    }
}
