import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.preJava5();
        runner.withJava8();
        runner.ifYouReallyHaveTo();
    }

    private void preJava5() {
        List myList = new ArrayList();
        myList.add("String Literal");
        myList.add(new Integer(23));
        myList.add(new Runner());

        // GETTING LIST ELEMENTS
        String s = (String) myList.get(0);

        Integer integer = (myList.get(1) instanceof Integer) ? (Integer) myList.get(1) : null;

        Object object = myList.get(2);
        Runner runnerExample;
        if (object instanceof Runner) {
            runnerExample = (Runner) object;
        }

        // LOOPING
        for(Object o : myList) {
            if(o instanceof String) {
                System.out.println(o);
            }
        }
    }

    private void withJava8() {
        List<String> myList = new ArrayList<>();
        myList.add("SBB");
        myList.add("BLS");
        myList.add("RBS");

        String s1 = myList.get(0);
        String s2 = myList.get(1);
        String s3 = myList.get(2);

        // LOOPING
        for(String s : myList) {
            System.out.println(s);
        }
    }

    private void ifYouReallyHaveTo() {
        List<Object> myFirstList = new ArrayList<Object>();
        // or with Java 7 diamond syntax
        List<Object> mySecondList = new ArrayList<>();
    }


}
