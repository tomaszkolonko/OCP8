import java.util.Map;
import java.util.TreeMap;

public class Glossar {
    static Map<String, String> sbbGlossar = new TreeMap<>();

    public static void main(String[] args) {
        populateGlossar();
        printGlossar();

        // add a new definition to the glossar if absent
        sbbGlossar.computeIfAbsent("SOBO", (k) -> "Sonderbelegungsobjek");

        // add a new definition to the glossar if absent
        sbbGlossar.computeIfAbsent("BP", (k) -> "Bauprojekt");

        printGlossar();

        // use a biFunction to replace all values in the map to uppercase
        sbbGlossar.replaceAll((key, oldValue) -> oldValue.toUpperCase());

        printGlossar();
    }

    static void populateGlossar() {
        sbbGlossar.put("EVU", "Eisenbahnverkehrsunternehmen");
        sbbGlossar.put("ISB", "Infrastrukturbetreiber");
        sbbGlossar.put("BP", "Betriebspunkt");
    }

    static void printGlossar() {
        System.out.println("\n--- current Glossar ---");
        sbbGlossar.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}
