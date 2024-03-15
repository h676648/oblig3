package oppg1;

import static oppg1.HobbyMatchMain.match;

public class Main {
    public static void main(String[] args) {
        Person Andreas = new Person ("Andreas", "gaming", "musikk", "venner");
        Person Jorgen = new Person ("Jorgen", "gaming", "tur", "mat");
        Person Tobias = new Person ("Tobias", "gaming", "festing", "fisking");
        double match1 = match(Andreas, Jorgen);
        double match2 = match(Andreas, Tobias);
        double match3 = match(Tobias, Jorgen);
        System.out.println(match1 + " " + match2 + " " + match3);
    }
}
