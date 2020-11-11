

public class Runner {
    private static char[] characterBillboard = new char[200];

    public static void main(String[] args) {
//        Runner runner = new Runner();

        Runnable runnableOne = () -> {
            String message = "Aldi han nun neue vegane Schnitzel im Sortiment. Nur 99 Franken pro Kilo!!! Aldi han nun neue vegane Schnitzel im Sortiment. Nur 99 Franken pro Kilo!!!";
            changeBillboard(message);
        };
        Runnable runnableTwo = () -> {
            String message = "The new Pixel phone is now being shipped to all customers. Congratulations. The new Pixel phone is now being shipped to all customers. Congratulations.";
            changeBillboard(message);
        };
        Runnable runnableThree = () -> {
            String message = "This is a story about a long long forgotten dragon in the mountains of Bern This is a story about a long long forgotten dragon in the mountains of Bern";
            changeBillboard(message);
        };

        Thread tOne = new Thread(runnableOne);
        Thread tTwo = new Thread(runnableTwo);
        Thread tThree = new Thread(runnableThree);

        tOne.setName("Thread-One");
        tOne.start();
        tTwo.setName("Thread-Two");
        tTwo.start();
        tThree.setName("Thread-Three");
        tThree.start();

//        runner.mixUpTheBillboard("asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasd");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println();
        }

        System.out.println(characterBillboard);
    }

    private synchronized static void changeBillboard(String message) {
        for(int runs = 0; runs < 100; runs++) {
            for (int x = 0; x < message.length(); x++) {
                characterBillboard[x] = message.charAt(x);
            }
            for(int x = 0; x < message.length(); x++) {
                if(characterBillboard[x] != message.charAt(x)) {
                    System.out.println(characterBillboard);
                    break;
                }
            }

        }
    }

//    private synchronized void mixUpTheBillboard(String message) {
//        for(int runs = 0; runs < 100; runs++) {
//            for (int x = 0; x < message.length(); x++) {
//                characterBillboard[x] = message.charAt(x);
//            }
//            for(int x = 0; x < message.length(); x++) {
//                if(characterBillboard[x] != message.charAt(x)) {
//                    System.out.println(characterBillboard);
//                    break;
//                }
//            }
//
//        }
//    }

}
