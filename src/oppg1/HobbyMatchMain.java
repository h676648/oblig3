package oppg1;

public class HobbyMatchMain {
    private static String[] aHobbyer;
    private static String[] bHobbyer;
    private static double antallKunHosDenEne;
    private static double antallKunHosDenAndre;
    private static double antallTotalt;
    private static double antallFelles;

    public static double match(Person a, Person b){
        antallFelles = 0;
        aHobbyer = a.getHobbyer();
        bHobbyer = b.getHobbyer();
        antallKunHosDenEne = a.mengdeHobbyer();
        antallKunHosDenAndre = b.mengdeHobbyer();
        antallTotalt = antallKunHosDenEne + antallKunHosDenAndre;
        for (int i = 0; i < a.mengdeHobbyer(); i++) {
            for (int y = 0; y < b.mengdeHobbyer(); y++) {
                if (aHobbyer[i].equals(bHobbyer[y])) {
                    antallFelles++;
                }
            }

        }
        double match = antallFelles / antallTotalt;
        return match;
    }

}
