package generic;

import java.util.List;

/**
 * @author chenlei10
 * @date 2018/1/22 14:06
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





