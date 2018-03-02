package currency.basic.volatileTest;

/**
 * 使用volatile进行双重校验
 * @Author chenlei10
 * @Date 2018/1/29 18:17
 */
public class Singleton {
    //volatile保证了可见性
    private static volatile Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null) {
            //synchronized保证了原子性
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
