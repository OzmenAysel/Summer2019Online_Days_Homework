package tests.BasicNavigation.utilities;

public class Wait {

    public static void wait(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
