import java.util.ArrayList;
import java.util.List;

public class RunnerSpecialCases {
    public static void main(String[] args) {
        RunnerSpecialCases runnerSpecialCases = new RunnerSpecialCases();

        List<Dog> dogList = new ArrayList<Dog>();
        dogList.add(new Dog(234));
        dogList.add(new Dog(23));

        runnerSpecialCases.specialCaseOne(dogList);
//        runnerSpecialCases.specialCaseTwo(dogList);
        runnerSpecialCases.specialCaseThree(dogList);
    }

    private void specialCaseOne(List<?> list) {
        System.out.println();
        for(Object dog : list) {
            if(dog instanceof Dog) {
                System.out.println(((Dog) dog).getType());
            }
        }
//        list.add(new Dog(777));
    }

    private void specialCaseTwo(List<Object> list) {
        System.out.println();
        for(Object o : list) {
            if(o instanceof Dog) {
                System.out.println(((Dog) o).getType());
            }
        }
    }

    private void specialCaseThree(List<? extends Object> list) {
        System.out.println();
        for(Object o : list) {
            if(o instanceof Dog) {
                System.out.println(((Dog) o).getType());
            }
        }
//        list.add(new Dog(777));
    }
}
