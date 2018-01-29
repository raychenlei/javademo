package currency.basic.volatileDemo;

/**
 * @Author chenlei10
 * @Date 2018/1/29 16:17
 */
public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count:" + task.count);
    }
}

class MyTask implements Runnable{
    int count = 0;
    public void run() {
        for (int j=0;j<10000;j++){
            increase();
        }
    }

    public  void increase(){
        count ++;
    }
}


