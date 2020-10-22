import java.util.ArrayList;
import java.util.List;

public class MyMoleskin {

    public static void main(String[] args)  {
        MyMoleskin myMoleskin = new MyMoleskin();

        TodoList todoList = new TodoList();
        List<String> list = new ArrayList<>();
        todoList.addItem(new Countable() {
            @Override
            public int getCurrentCount() {
                return 42;
            }

            @Override
            public void addItem() {
                System.out.println("Thanks for adding an item");
            }
        });

        System.out.println("\n================\n");

        SomeOtherClass someOtherClass = new SomeOtherClass();
        todoList.addItem(someOtherClass);
    }
}


class TodoList {
    void addItem(Countable c) {
        c.addItem();
        c.getCurrentCount();
    }
}


class SomeOtherClass implements Countable {
    @Override
    public int getCurrentCount() {
        return 923765;
    }

    @Override
    public void addItem() {
        System.out.println("Seperate Class that implements the interface");
    }
}
