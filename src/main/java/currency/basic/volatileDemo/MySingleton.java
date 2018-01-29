package currency.basic.volatileDemo;

/**
 *
 * @Author chenlei10
 * @Date 2018/1/29 18:17
 */
public class MySingleton {
    private static volatile MySingleton instance = null;

    private MySingleton(){

    }

    public static MySingleton getInstance(){
        if (instance == null) {
            synchronized (MySingleton.class){
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }

}
