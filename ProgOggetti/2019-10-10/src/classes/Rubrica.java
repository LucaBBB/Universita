package classes;

import java.util.ArrayList;

public class Rubrica {
    static final int MAX_DIM = 6;
    private static ArrayList<String> rubrica;

    /**
     * Metodo che crea la Rubrica
     */
    public static void crea() {
        rubrica = new ArrayList<>();
    }

    /**
     * Metodo che restituisce il numero di elementi in Rubrica
     * @return il numero di elementi nell'ArrayList
     */
    public static int numEl() {
        return rubrica.size();
    }

    /**
     * Metodo che aggiunge una nuova stringa alla rubrica.
     * @return  -1 se la rubrica e' piena;<br>
     *           0 se la stringa e' gia' presente in rubrica;<br>
     *           1 se la stringa e' stata aggiunta correttamente.
     */
    public static int add(String s) {
        if (rubrica.size() == MAX_DIM)
            return -1;
        if (rubrica.contains(s))
            return 0;
        rubrica.add(s);
        return 1;
    }

    /**
     * Metodo che cerca tutte le stringhe che iniziano con la stringa passata in input.
     * @param s la stringa parametro di ricerca.
     * @return l'ArrayList contenente tutte le stringhe trovate, oppure un'ArrayList vuota.
     */
    public static ArrayList<String> findByString(String s) {
        ArrayList<String> match = new ArrayList<>();

        for (String si : rubrica) {
            if (si.startsWith(s))
                match.add(si);
        }

        return match;
    }

    /**
     * Metodo che rimuove tutte le stringhe che iniziano con la stringa passata in input.
     * @param s la stringa parametro di ricerca.
     * @return il numero di stringhe rimosse.
     */
    public static int remove (String s) {
        int rimossi = 0;

        for (int i=0; i<rubrica.size(); i++) {
            String si = rubrica.get(i);
            if (si.startsWith(s)) {
                rubrica.remove(si);
                rimossi++;
            }
        }

        return rimossi;
    }

    /**
     * Metodo che svuota la Rubrica
     */
    public static void svuota() {
        rubrica.clear();
    }
}
