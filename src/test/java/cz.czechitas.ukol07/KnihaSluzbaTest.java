package cz.czechitas.ukol07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KnihaSluzbaTest {

    @Test
    public void testGetVsechnyKnihy() {
        KnihaSluzba sluzba = new KnihaSluzba();
        List<Kniha> knihy = sluzba.getVsechnyKnihy();
        assertNotNull(knihy);
        assertEquals(14, knihy.size(), "Databáze by měla obsahovat 14 knih");
    }

    @Test
    public void testGetKnihyOdAutoraNajdeJednu() {
        KnihaSluzba sluzba = new KnihaSluzba();
        List<Kniha> knihy = sluzba.getKnihyOdAutora("Karel Čapek");
        assertEquals(5, knihy.size(), "Karel Čapek má mít 5 knihy");
    }

    @Test
    public void testGetKnihyOdAutoraNenajdeZadne() {
        KnihaSluzba sluzba = new KnihaSluzba();
        List<Kniha> knihy = sluzba.getKnihyOdAutora("Neexistující Autor");
        assertTrue(knihy.isEmpty(), "Seznam by měl být prázdný");
    }

    @Test
    public void testGetKnihyZRokuNajdeVice() {
        KnihaSluzba sluzba = new KnihaSluzba();
        List<Kniha> knihy = sluzba.getKnihyZRoku(1845);
        assertEquals(2, knihy.size(), "Rok 1845 má mít 2 knihy");
    }

    @Test
    public void testGetKnihyZRokuNenajdeZadne() {
        KnihaSluzba sluzba = new KnihaSluzba();
        List<Kniha> knihy = sluzba.getKnihyZRoku(2000);
        assertTrue(knihy.isEmpty(), "Žádná kniha z roku 2000 by neměla být");
    }
}
