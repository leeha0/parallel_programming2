package chapter13;

public class ThreadEx12_2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 종료>>");
    }
}
