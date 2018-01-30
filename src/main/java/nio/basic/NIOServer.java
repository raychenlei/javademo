package nio.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author chenlei10
 * @Date 2018/1/30 9:52
 */
public class NIOServer implements Runnable {

    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public NIOServer(int port) {
        try {
            selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(port));

            ssc.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started, port:" + port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        while (true){
            try {
                this.selector.select();
                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            accept(key);
                        }else if(key.isReadable()){
                            read(key);
                        }else if(key.isWritable()){
                            write(key);
                        }
                    }
                    iterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void write(SelectionKey key) throws IOException {
        this.writeBuffer.clear();
        SocketChannel sc = (SocketChannel) key.channel();
        String responseMsg = "服务器已收到你的消息";
        byte[] bytes = responseMsg.getBytes("utf-8");
        writeBuffer.put(bytes);
        writeBuffer.flip();
        sc.write(writeBuffer);
    }

    private void read(SelectionKey key) throws IOException {
        this.readBuffer.clear();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        if (!socketChannel.isConnected()) {
            System.out.println("客户端" + socketChannel.getLocalAddress() + "已关闭");
        }
        int count = socketChannel.read(readBuffer);
        if (count == -1) {
            closeSK(key);
            return;
        }
        this.readBuffer.flip();
        byte[] bytes = new byte[this.readBuffer.remaining()];
        this.readBuffer.get(bytes);
        String content = new String(bytes).trim();
        System.out.println("接收到客户端" + socketChannel.getLocalAddress() + "的数据:" + content);

        //将客户端channel注册写事件
        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    private void closeSK(SelectionKey key) throws IOException {
        key.channel().close();
        key.cancel();
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = ssc.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(this.selector,SelectionKey.OP_READ);
    }

    public static void main(String[] args) {
        NIOServer server = new NIOServer(8000);
        new Thread(server).start();
    }

}
