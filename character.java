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
    private final Dice Dice = new Dice();

    public String Getclass(){

    }

    public character(String name, String charType) {
        this.name = name;
        this.charType = Getclass();
        this.level = 1;
    }



}
