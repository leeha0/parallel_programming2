package chapter13;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinEx1 {

    static final ForkJoinPool pool = new ForkJoinPool(); // 쓰레드 풀을 생성

    public static void main(String[] args) {
        long from = 1L, to = 100_000L;

        SumTask task = new SumTask(from, to);

        Long start = System.currentTimeMillis(); // 시작시간 초기화
        // 작읍을 합치고 나누는데 걸리는 시간이 소요
        Long result = pool.invoke(task);
        System.out.println("Elapsed time:" + (System.currentTimeMillis() - start));

        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis(); // 시작시간 초기화
        for (long i = from; i < to; i++) {
            result += i;
        }

        System.out.println("Elapsed time:" + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
    }
}
