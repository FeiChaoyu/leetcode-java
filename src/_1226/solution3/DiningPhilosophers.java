package _1226.solution3;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author feichaoyu
 */

class DiningPhilosophers {

    /**
     * 1个Fork视为1个boolean变量，false则无人使用，true则有人使用
     */
    private volatile boolean[] forkList = new boolean[5];

    /**
     * 限制最多只有4个哲学家可以拿叉子
     */
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        // 左边的叉子的编号
        int leftFork = philosopher;
        // 右边的叉子的编号
        int rightFork = (philosopher + 1) % 5;

        // 可以拿叉子的人数-1
        eatLimit.acquire();

        // 左边叉子已经被人拿过了就在此等待。类似于lock把你锁住，不让你进来
        while (forkList[leftFork]) {
            Thread.sleep(1);
        }
        // 拿起左边的叉子
        forkList[leftFork] = true;

        // 右边叉子已经被人拿过了就在此等待
        while (forkList[rightFork]) {
            Thread.sleep(1);
        }
        // 拿起右边的叉子
        forkList[rightFork] = true;

        // 拿起左边的叉子的具体执行任务
        pickLeftFork.run();
        // 拿起右边的叉子的具体执行任务
        pickRightFork.run();

        // 吃意大利面的具体执行任务
        eat.run();

        // 放下左边的叉子的具体执行任务
        putLeftFork.run();
        // 放下右边的叉子的具体执行任务
        putRightFork.run();

        // 放下左边的叉子
        forkList[leftFork] = false;
        // 放下右边的叉子
        forkList[rightFork] = false;

        // 可以拿叉子的人数+1
        eatLimit.release();
    }
}

