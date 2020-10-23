import java.util.ArrayList;
import java.util.List;

public class MyMoleskin {
    List<TodoList> myLists = new ArrayList<>();

    public static void main(String[] args)  {
        MyMoleskin myMoleskin = new MyMoleskin();

        TodoList todoList = new TodoList();

        SomeOtherClass someOtherClass = new SomeOtherClass();
        todoList.addItem(someOtherClass);

        System.out.println("\n================\n");

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
        
        myMoleskin.myLists.add(todoList);
    }
}


class TodoList {
    void addItem(Countable c) {
        c.addItem();
        System.out.println("Print some count: " + c.getCurrentCount());
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
