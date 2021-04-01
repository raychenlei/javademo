package generic;

/**
 * @author chenlei
 * @version 1.0
 * @description
 * @date 2021/4/1 2:34 PM
 **/
public class Book2<T> {
    private T name;

    public T getName(){
        return name;
    }
}


class MathBook2 extends Book2<String>{
    @Override
    public String getName() {
        return super.getName();
    }
}


