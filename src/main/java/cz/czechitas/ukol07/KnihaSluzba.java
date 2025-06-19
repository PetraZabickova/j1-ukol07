package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class KnihaSluzba {

    private List<Kniha> knihy;

    public KnihaSluzba() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = KnihaSluzba.class.getResourceAsStream("knihy.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Soubor knihy.json nebyl nalezen.");
            }

            knihy = objectMapper.readValue(inputStream, new TypeReference<List<Kniha>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Chyba při načítání souboru knihy.json", e);
        }
    }

    // 1. Vrátí všechny knihy
    public List<Kniha> getVsechnyKnihy() {
        return knihy;
    }

    // 2. Vrátí knihy podle zadaného autora
    public List<Kniha> getKnihyOdAutora(String autor) {
        return knihy.stream()
                .filter(kniha -> kniha.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    // 3. Vrátí knihy vydané v zadaném roce
    public List<Kniha> getKnihyZRoku(int rok) {
        return knihy.stream()
                .filter(kniha -> kniha.getRokVydani() == rok)
                .collect(Collectors.toList());
    }
}
