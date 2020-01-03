package nio.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author chenlei10
 * @date 2018/1/30 15:20
 */
public class NIOClient implements Runnable {

    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);


    private NIOClient() {
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            socketChannel.register(this.selector, SelectionKey.OP_CONNECT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true){
            try {
                int count = selector.select();
                if (count <= 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isConnectable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        // 如果正在连接，则完成连接
                        if(socketChannel.isConnectionPending()){
                            socketChannel.finishConnect();
                        }
                        sendMsg(key);
                    }else if(key.isReadable()){
                        readFromServer(key);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void readFromServer(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        this.readBuffer.clear();
        socketChannel.read(readBuffer);
        readBuffer.flip();
        byte[] bytes = new byte[readBuffer.remaining()];
        readBuffer.get(bytes);
        System.out.println("服务器返回：" + new String(bytes));
    }

    private void sendMsg(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        writeBuffer.clear();
        byte[] bytes = new byte[1024];
        System.in.read(bytes);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        socketChannel.register(this.selector, SelectionKey.OP_READ);

//        while (true){
//            writeBuffer.clear();
//            byte[] bytes = new byte[1024];
//            System.in.read(bytes);
//            writeBuffer.put(bytes);
//            writeBuffer.flip();
//            socketChannel.write(writeBuffer);
//        }
    }

    public static void main(String[] args) {
        NIOClient client = new NIOClient();
        new Thread(client).start();
    }
}
