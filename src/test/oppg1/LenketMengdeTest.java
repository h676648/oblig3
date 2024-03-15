package oppg1;
import adt.MengdeADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LenketMengdeTest {

    private LenketMengde<Integer> mengde;
    @BeforeEach
    public void setUp() {
        mengde = new LenketMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);
    }
    @Test
    void erTom() {
        assertFalse(mengde.erTom());
    }

    @Test
    void inneholder() {
        assertTrue(mengde.inneholder(2));
        assertFalse(mengde.inneholder(4));
    }

    @Test
    void erDelmengdeAv() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);
        assertTrue(annenMengde.erDelmengdeAv(mengde));
    }

    @Test
    void erLik() {
        LenketMengde<Integer> likMengde = new LenketMengde<>();
        likMengde.leggTil(1);
        likMengde.leggTil(2);
        likMengde.leggTil(3);
        assertTrue(mengde.erLik(likMengde));
    }

    @Test
    void erDisjunkt() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(4);
        assertTrue(mengde.erDisjunkt(annenMengde));
    }

    @Test
    void snitt() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        MengdeADT<Integer> snitt = mengde.snitt(annenMengde);
        assertTrue(snitt.inneholder(2));
        assertTrue(snitt.inneholder(3));
        assertFalse(snitt.inneholder(1));
    }

    @Test
    void union() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(3);
        annenMengde.leggTil(4);
        MengdeADT<Integer> union = mengde.union(annenMengde);
        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
        assertTrue(union.inneholder(4));
    }

    @Test
    void differanse() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);
        annenMengde.leggTil(4);
        MengdeADT<Integer> differanse = mengde.differanse(annenMengde);
        assertTrue(differanse.inneholder(1));
        assertFalse(differanse.inneholder(2));
        assertFalse(differanse.inneholder(3));
        assertFalse(differanse.inneholder(4));
    }

    @Test
    void leggTil() {
        mengde.leggTil(4);
        assertTrue(mengde.inneholder(4));
    }

    @Test
    void leggTilAlleFra() {
        LenketMengde<Integer> annenMengde = new LenketMengde<>();
        annenMengde.leggTil(4);
        annenMengde.leggTil(5);
        mengde.leggTilAlleFra(annenMengde);
        assertTrue(mengde.inneholder(4));
        assertTrue(mengde.inneholder(5));
    }

    @Test
    void fjern() {
        assertEquals(2, mengde.fjern(2));
        assertFalse(mengde.inneholder(2));
    }

    @Test
    void antallElementer() {
        assertEquals(3, mengde.antallElementer());
    }
}