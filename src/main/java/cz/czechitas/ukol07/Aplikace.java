package cz.czechitas.ukol07;

import java.util.List;

public class Aplikace {

    public static void main(String[] args) {
        KnihaSluzba sluzba = new KnihaSluzba();

        // 1. Výpis celkového počtu knih
        List<Kniha> vsechnyKnihy = sluzba.getVsechnyKnihy();
        System.out.println("Celkový počet knih: " + vsechnyKnihy.size());

        // 2. Výpis názvů knih Karla Čapka
        System.out.println("\nKnihy od Karla Čapka:");
        sluzba.getKnihyOdAutora("Karel Čapek").forEach(kniha -> System.out.println("- " + kniha.getNazev()));

        // 3. Výpis knih z roku 1845
        System.out.println("\nKnihy z roku 1845:");
        sluzba.getKnihyZRoku(1845).forEach(kniha -> System.out.println(kniha.getAutor() + ": " + kniha.getNazev()));
    }
}

