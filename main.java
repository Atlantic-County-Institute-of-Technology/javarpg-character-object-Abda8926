import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Choose your class! (Melee, Ranged, Magic)");
        Scanner scan = new Scanner(System.in);
        String Class = scan.nextLine();
        System.out.println("Choose your name!");
        String Name = scan.nextLine();
        character plyr = new character(Name, Class, 1);
        plyr.rollStats();
        System.out.println(plyr);
    }

}
