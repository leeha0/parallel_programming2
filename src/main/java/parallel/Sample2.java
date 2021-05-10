package parallel;

import java.util.HashMap;

public class Sample2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        Thread thread = new Thread(() -> hashMap.put("API", "result"));
        thread.start();
        System.out.println(hashMap.get("API")); // null
    }
}
