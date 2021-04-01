package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author raychenlei
 * @date 2017/10/6 22:17
 */
public class InetDemo01 {
    public static void main(String[] args) throws UnknownHostException {
        //输出本机IP、计算机名
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("local IP :" + localHost.getHostAddress());
        System.out.println("localHost name :" + localHost.getHostName());

        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println("baidu IP :" + address.getHostAddress());
        InetAddress address1 = InetAddress.getByAddress(address.getAddress());
        System.out.println(address1.getHostName());

    }
}
