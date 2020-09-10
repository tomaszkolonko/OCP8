import model.BMW;
import model.Ford;
import util.Utils;

public class Runner {

    public static void main(String[] args) {
        BMW e92 = new BMW(90_000, 2018, "BMW E92 M3 CP", 500, false);
        e92.accelerate();
        e92.turn();
        e92.fillUp();

        Ford mustang = new Ford(80_000, 2017, "Mustang BULLIT");
        mustang.accelerate();
        mustang.turn();
        mustang.fillUp();

        Utils.compare(e92, mustang);

    }

}
