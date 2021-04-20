package chapter13;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private long from;
    private long to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long size = to - from + 1; // from <= i <= to

        if (size <= 5) {
            return sum();
        }

        long half = (from + to) / 2;

        // 범위를 반으로 나눠서 두 개의 작업 생성
        SumTask leftTask = new SumTask(from, half);
        SumTask rightTask = new SumTask(half + 1, to);

        leftTask.fork();

        return rightTask.compute() + leftTask.join();
    }

    private long sum() {
        long tmp = 0L;

        for (long i = from; i <= to; i++) {
            tmp += i;
        }

        return tmp;
    }
}
