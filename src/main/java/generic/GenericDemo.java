package generic;

import java.util.List;

/**
 * @Author chenlei10
 * @Date 2018/1/22 14:06
 */
public class GenericDemo {
    public static void main(String[] args) {

    }

    /**
     * 泛型擦除和桥方法
     */
    public void eraseGeneric(){
        Node node = new MyNode();
        node.setData("Test");//编译不会报错，运行时会报错，因为走的是桥方法
    }

    /**
     * PECS
     */
    public void genericBound(){
//        FruitList<Fruit>
    }

}



class Node<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        System.out.println("Node setData");
        this.data = data;
    }
}

class MyNode extends Node<Integer> {

    /**
     * 编译时编译器会生成这么一个桥方法，这才是实际覆盖了父类的方法，父类中的T都被擦除，变成了Object
     * <p>
     * public void setData(Object data) {
     * setData((Integer) data);
     * }
     **/

    @Override
    public void setData(Integer data) {
        System.out.println("MyNode setData");
        super.setData(data);
    }
}

class Fruit{}
class Apple extends Fruit{}
class Orange extends Fruit{}

class FruitList<T>{

    public T readList(List<T> list){
        return list.get(0);
    }
}





