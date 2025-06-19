package cz.czechitas.ukol07;

public class Kniha {
    private String autor;
    private String nazev;
    private int rokVydani;

    // Bezparametrový konstruktor (nutný pro JavaBean)
    public Kniha() {
    }

    // Getter a setter pro autor
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Getter a setter pro nazev
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    // Getter a setter pro rokVydani
    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    // Volitelně: toString() pro ladění nebo výpis
    @Override
    public String toString() {
        return nazev + " (" + autor + ", " + rokVydani + ")";
    }
}
