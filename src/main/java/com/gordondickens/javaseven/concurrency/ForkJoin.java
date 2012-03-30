package com.gordondickens.javaseven.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
    private static final Logger logger = LoggerFactory.getLogger(ForkJoin.class);

    private static int numbers[] = new int[100000];

    private static class SumOfSquaresTask extends RecursiveTask<Long> {

        private int threshold = 1000;
        private int from;
        private int to;

        public SumOfSquaresTask(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            long sum = 0L;
            int mid = (to + from) >>> 1;

            if ((to - from) < threshold) {
                for (int i = from; i < to; i++) {
                    sum += numbers[i] * numbers[i];
                }
                return sum;
            } else {
                List<RecursiveTask<Long>> forks = new ArrayList<>();
                SumOfSquaresTask task1 =
                        new SumOfSquaresTask(from, mid);
                SumOfSquaresTask task2 =
                        new SumOfSquaresTask(mid, to);
                forks.add(task1);
                task1.fork();
                forks.add(task2);
                task2.fork();

                for (RecursiveTask<Long> task : forks) {
                    sum += task.join();
                }
                return sum;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        long startTime;
        long stopTime;

        long sum = 0L;
        startTime = System.currentTimeMillis();
        for (int number : numbers) {
            sum += number * number;
        }
        logger.debug("Sum of squares: {}", sum);
        stopTime = System.currentTimeMillis();
        logger.debug("Iterative solution time: {}", (stopTime - startTime));

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        startTime = System.currentTimeMillis();
        long result = forkJoinPool.invoke(new SumOfSquaresTask(0, numbers.length));
        logger.debug("forkJoinPool: {}", forkJoinPool.toString());
        logger.debug("forkJoinPool: {}", forkJoinPool.toString());
        stopTime = System.currentTimeMillis();
        logger.debug("Sum of squares: {}", result);
        logger.debug("Fork/join solution time: {}", (stopTime - startTime));
    }
}
