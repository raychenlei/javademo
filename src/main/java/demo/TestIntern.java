package demo;

/**
 * @author chenlei10
 * @date 2018/3/26 18:51
 */
public class TestIntern {
    public static void main(String[] args) {
        /**
         * 这里都是基于1.7~ 想了解intern()就需要了解 栈 堆 运行时常量池。了解一个字符串对象到底是怎样存储的！才能灵活运用
         * intern()作用分析
         * 判断这个常量是否存在于常量池。
         * 1.存在：判断存在内容是引用还是常量。如果是引用，返回引用地址指向堆空间对象。如果是常量则直接返回常量池常量
         * 2.不存在：将当前对象引用复制到常量池。并且返回的是当前对象的引用
         *
         * 直接使用双引号常量分析
         * 判断这个常量是否存在于常量池
         * 1.存在：判断这个常量是存在的引用还是常量。如果是引用，返回这个引用指向堆空间的对象。如果是常量则直接返回常量池常量
         * 2.不存在：直接将此常量添加到常量池。并且返回此常量
         *
         * new String对象分析
         * new一个String对象做了两个操作
         * 1.保存对象到堆空间。
         * 2.将这个对象的内容作为常量保存到常量池
         * 这里只接受new 对象里面的内容到常量池。不包括append 和连接对象
         *
         * 直接使用双引号常量和new String对象的区别
         * 直接双：
         *     加号连接会直接组合成一个常量保存的常量池
         *     声明两个引用使用双。在将引用加号连接会保存一个或者两个常量到常量池（两个是因为两个的内容不一致）。和一个组合对象到堆空间
         * new String:
         *     加号连接会添加两个对象到堆和一个或者两个常量到常量池（两个是因为加号前后的内容不一致）
         * 直双加newSting:
         *     加号连接会保存2个对象到堆（一个是new的一个是new+直双后的）。保存一个或者两个常量到常量池（内容不一致两个）
         *
         * 直接使用双引号常量分析能证明局部常量会受到执行顺序影响
         * 执行过intern()对象并且保存了引用到常量池后。。gc是没法回收这个对象的。因为它引用一直在
         */
        String aa = "AA";//设置常量AA到常量池
        String bb = "BB";//设置常量BB到常量池
        String ccdd = "CC"+"DD";//设置常量CCDD到常量池
        String neeff = new String("EE")+new String("FF");//设置EE和FF到常量池。并且添加EE、FF和EEFF对象到堆
        String aabb = aa+bb;//添加AABB对象到堆
        String gghh = "GG"+new String("HH");//设置GG和HH常量到常量池,设置HH和GGHH对象到堆
//         aa.intern();//啥事都不做，返回AA常量
//         ccdd.intern();//啥事都不做，返回CCDD常量
//         neeff.intern();//添加EEFF对象的引用到常量池，并返回EEFF对象
//         aabb.intern();//添加AABB对象的引用到常量池，并返回AABB对象
//         gghh.intern();//添加GGHH对象的引用到常量池，并返回GGHH对象
        System.out.println(aa.intern()==aa);
        System.out.println(neeff.intern()=="EEFF");
        System.out.println("EEFF"==neeff);
        String nccdd = new String("CCDD");
        System.out.println(ccdd==nccdd);
        System.out.println(ccdd==nccdd.intern());
        System.out.println(aabb.intern()==aabb);
        System.out.println(gghh==gghh.intern());
    }
}
