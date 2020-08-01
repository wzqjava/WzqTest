package wzq.com.lib;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * author:Created by WangZhiQiang on 2018/11/21.
 * 1��CountDownLatch��CyclicBarrier���ܹ�ʵ���߳�֮��ĵȴ���ֻ�������ǲ��ص㲻ͬ��
 *
 * ��������CountDownLatchһ������ĳ���߳�A�ȴ����ɸ������߳�ִ��������֮������ִ�У�
 *
 * ����������CyclicBarrierһ������һ���̻߳���ȴ���ĳ��״̬��Ȼ����һ���߳���ͬʱִ�У�
 *
 * �����������⣬CountDownLatch�ǲ��ܹ����õģ���CyclicBarrier�ǿ������õġ�
 *
 * ����2��Semaphore��ʵ�����е����ƣ���һ�����ڿ��ƶ�ĳ����Դ�ķ���Ȩ�ޡ�
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N,new Runnable() {
            @Override
            public void run() {
                System.out.println("��ǰ�߳�"+Thread.currentThread().getName());
            }
        });

        for(int i=0;i<N;i++)
            new Writer(barrier).start();
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("�߳�"+Thread.currentThread().getName()+"����д������...");
            try {
                Thread.sleep(5000);      //��˯����ģ��д�����ݲ���
                System.out.println("�߳�"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            //  ���ӡ4��,�̴߳ﵽͬһ״̬��,ͬʱ����;
            System.out.println("�����߳�д����ϣ�����������������...");
        }
    }
}
