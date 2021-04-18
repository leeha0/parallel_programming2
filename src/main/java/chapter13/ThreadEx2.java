package chapter13;

public class ThreadEx2 {

    public static void main(String[] args) {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();

//        java.lang.Exception
//        at chapter13.ThreadEx2_1.throwException(ThreadEx2_1.java:12)
//        at chapter13.ThreadEx2_1.run(ThreadEx2_1.java:7) // 호출 스택의 첫 번째 메서드가 run 메서드
    }
}
