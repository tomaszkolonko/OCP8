import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface ETCSChecker {

    default int getETCSordinalValue(ETCSLevel etcsLevel) {
        return etcsLevel.ordinal();
    }

    static List<String> getCountriesWithETCSConformity() {
        return new ArrayList<>(Arrays.asList("Switzerland", "Germany", "Franche", "Italy"));
    }

    boolean etcsCheck(Train train, Track track);

}
