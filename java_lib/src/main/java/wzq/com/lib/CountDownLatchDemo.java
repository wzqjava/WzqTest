package wzq.com.lib;

/**
 * https://www.cnblogs.com/dolphin0520/p/3920397.html
 * 1��CountDownLatch��CyclicBarrier���ܹ�ʵ���߳�֮��ĵȴ���ֻ�������ǲ��ص㲻ͬ��
 * CountDownLatchһ������ĳ���߳�A�ȴ����ɸ������߳�ִ��������֮������ִ�У�
 * ��CyclicBarrierһ������һ���̻߳���ȴ���ĳ��״̬��Ȼ����һ���߳���ͬʱִ�У�
 * ���⣬CountDownLatch�ǲ��ܹ����õģ���CyclicBarrier�ǿ������õġ�
 * Semaphore��ʵ�����е����ƣ���һ�����ڿ��ƶ�ĳ����Դ�ķ���Ȩ�ޡ�
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
         /*final CountDownLatch latch = new CountDownLatch(2);

         new Thread(){
             public void run() {
                 try {
                     System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                     Thread.sleep(3000);
                     System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
                     latch.countDown();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             };
         }.start();

         new Thread(){
             public void run() {
                 try {
                     System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                     Thread.sleep(3000);
                     System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
                     latch.countDown();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             };
         }.start();

         try {
             System.out.println("�ȴ�2�����߳�ִ�����...");
             latch.await(); //���߳�await;
             System.out.println("2�����߳��Ѿ�ִ�����");
             System.out.println("����ִ�����߳�");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }*/
    }

}
