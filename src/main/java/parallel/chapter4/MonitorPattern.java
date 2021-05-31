package parallel.chapter4;

public class MonitorPattern {

    // 모니터 역할을 하는 객체
    private Object monitor = new Object();

    public void synchronizedMethod(String name) {
        synchronized (monitor) {
            // 모니터 영역과 모니터를 획득한다.
            // 동기화 영역은 모니터 영역으로 한번에 한 스레드만 접근할 수 있다.
            System.out.println(name + " accessed here");
        }
        // 모니터 영역과 모니터는 해제된다.
    }
}
