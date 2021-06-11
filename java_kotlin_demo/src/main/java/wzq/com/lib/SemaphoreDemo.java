package wzq.com.lib;

import java.util.concurrent.Semaphore;

/**
 * author:Created by WangZhiQiang on 2018/11/21.
 * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目, //参数5:permits表示许可数目，即同时可以允许多少线程进行访问

        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
