package chapter13;

public class ThreadEx3 {

    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();

//        java.lang.Exception
//        at chapter13.ThreadEx3_1.throwException(ThreadEx3_1.java:12)
//        at chapter13.ThreadEx3_1.run(ThreadEx3_1.java:7)
//        at chapter13.ThreadEx3.main(ThreadEx3.java:7) // 호출스택의 첫 번째 메서드가 main 메서드
    }
}
