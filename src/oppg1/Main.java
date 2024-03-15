package oppg1;

import static oppg1.HobbyMatchMain.match;

public class Main {
    public static void main(String[] args) {
        Person Andreas = new Person ("Andreas", "gaming", "musikk", "venner");
        Person Jorgen = new Person ("Jorgen", "gaming", "venner", "mat");
        Person Tobias = new Person ("Tobias", "film", "festing", "mat");
        double match1 = match(Andreas, Jorgen);
        double match2 = match(Andreas, Tobias);
        double match3 = match(Tobias, Jorgen);
        double match4 = match(Jorgen, Andreas);
        double match5 = match(Tobias, Tobias);
        System.out.println(match1 + " " + match2 + " " + match3);
        System.out.println(match4);
        System.out.println(match5);
    }
}
