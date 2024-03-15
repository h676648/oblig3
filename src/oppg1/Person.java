package oppg1;

public class Person {
    private String navn;
    private String[] hobbyer;
    private int mengdeHobbyer;
    public Person(String navn, String ... hobbyer) {
        this.navn = navn;
        this.hobbyer = hobbyer;
        this.mengdeHobbyer = mengdeHobbyer();
    }

    public String getNavn() {
        return navn;
    }

    public String[] getHobbyer() {
        return hobbyer;
    }
    public int mengdeHobbyer() {
        int y = 0;
        for (int i = 0; i<hobbyer.length; i++) {
            if (hobbyer[i] != null) {
                y++;
            }
        }
        return y;
    }
    public boolean inneholder(String element) {
        for (int i = 0; i < mengdeHobbyer; i++) {
            if (hobbyer[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
