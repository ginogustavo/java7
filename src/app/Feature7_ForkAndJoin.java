package app;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**Parallel programming */

/**
 * Fork-Join breaks the task at hand into mini-tasks until the mini-task is
 * simple enough that it can be solved without further breakups. It’s like a
 * divide-and-conquer algorithm. One important concept to note in this framework
 * is that ideally no worker thread is idle. They implement a work-stealing
 * algorithm in that idle workers “steal” the work from those workers who are
 * busy
 * Need to finish the guide below
 * TODO: https://www.pluralsight.com/guides/introduction-to-the-fork-join-framework
 */
public class Feature7_ForkAndJoin {
    public static void main(String[] args) {

        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);

        // Default instantiation set the parallelism level equal to the same number
        // obtained as above
        ForkJoinPool pool2 = new ForkJoinPool();

        /*
         Two implementation of ForkJoinTask:
         RecursiveAction: Does not return a value
         RecursiveTask: returns an object of specified type
        */

        MyBigProblemTask problemTask = new MyBigProblemTask();
        pool.invoke(problemTask);
    }

}


class MyBigProblemTask extends RecursiveAction{

    @Override
    protected void compute() {
        //Your problem invocation goes here
    }
    
}