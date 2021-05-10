package parallel;

import java.util.HashMap;

public class Sample3 {
    public static void main(String[] args) throws InterruptedException {
        HashMap hashMap = new HashMap();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                hashMap.put("API", "result");
                synchronized (hashMap) {
                    hashMap.notify();
                }
            }
        });

        thread.start();
        if (hashMap.get("API") == null) {
            synchronized (hashMap) {
                hashMap.wait();
            }
        }
        System.out.println(hashMap.get("API"));
    }
}
