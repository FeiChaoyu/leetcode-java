package _1226.solution2;

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
        int leftFork = (philosopher + 1) % 5;
        // 右边的叉子的编号
        int rightFork = philosopher;

        // 编号为偶数的哲学家，优先拿起左边的叉子，再拿起右边的叉子
        if (philosopher % 2 == 0) {
            lockList[leftFork].lock();
            lockList[rightFork].lock();
        }
        // 编号为奇数的哲学家，优先拿起右边的叉子，再拿起左边的叉子
        else {
            lockList[rightFork].lock();
            lockList[leftFork].lock();
        }

        // 拿起左边的叉子的具体执行
        pickLeftFork.run();
        // 拿起右边的叉子的具体执行
        pickRightFork.run();

        // 吃意大利面的具体执行
        eat.run();

        // 放下左边的叉子的具体执行
        putLeftFork.run();
        // 放下右边的叉子的具体执行
        putRightFork.run();

        // 放下左边的叉子
        lockList[leftFork].unlock();
        // 放下右边的叉子
        lockList[rightFork].unlock();
    }
}


