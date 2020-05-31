package _1226.solution1;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author feichaoyu
 */

class DiningPhilosophers {
    /**
     * 1个Fork视为1个ReentrantLock，将5个Fork都放入数组中
     */
    private ReentrantLock[] lockList = new ReentrantLock[5];

    {
        Arrays.fill(lockList, new ReentrantLock());
    }

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

        // 拿起左边的叉子
        lockList[leftFork].lock();
        // 拿起右边的叉子
        lockList[rightFork].lock();

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
        lockList[leftFork].unlock();
        // 放下右边的叉子
        lockList[rightFork].unlock();

        // 可以拿叉子的人数+1
        eatLimit.release();
    }
}

