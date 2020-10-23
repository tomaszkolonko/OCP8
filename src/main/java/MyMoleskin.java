

public class MyMoleskin {

    public static void main(String[] args)  {
        MyMoleskin myMoleskin = new MyMoleskin();

        TodoList todoList = new TodoList();
        todoList.addItem(new Countable() {
            @Override
            public void getCurrentCount() {
                System.out.println("42");;
            }
        });

        System.out.println("\n================\n");

        SomeOtherClass someOtherClass = new SomeOtherClass();
        todoList.addItem(someOtherClass);

        System.out.println("\n================\n");

        todoList.addItem(() -> System.out.println("-42"));
    }
}


class TodoList {
    void addItem(Countable c) {
        c.getCurrentCount();
    }
}


// Countable is a functional interface with only one abstract method.
class SomeOtherClass implements Countable {
    @Override
    public void getCurrentCount() {
        System.out.println("923765");
    }
}
