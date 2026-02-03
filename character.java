import java.util.*;

public class character {
    Scanner scan = new Scanner(System.in);
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

    public String Getclass(){
        System.out.println("Choose your class! (Melee, Range, Magic)");
        String Class = scan.nextLine();
        return Class;
    }

    public String getName(){
        System.out.println("Choose your name!");
        String Name = scan.nextLine();
        return Name;
    }

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
    public rollStat(){
        dice.addDice(4, 6);
        dice.rollAll();


    }
    public boolean isAlive(){
        return hitPoints > 0;
    }

}
