package exception;

/**
 * @utheor chenlei
 * @Date: 2018/7/10 13:04
 * @Description:
 */
public class ExceptionDemo {
    public void testException(){
        try{
            throw new IllegalArgumentException("");
        }catch (IllegalArgumentException ie){
            System.out.println("catch IllegalArgumentException");
            throw new RuntimeException("");
        }catch (RuntimeException re){
            System.out.println("catch RuntimeException");
        }catch (Exception e){
            System.out.println("catch Exception");
        }
    }
}
