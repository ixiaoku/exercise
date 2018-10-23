package socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 多线程服务端
 * @author dcr
 *
 */
class SingleServer implements Runnable {

    private Socket socket;
    private int clientNo;

    public SingleServer(Socket socket, int clientNo) {
        this.socket = socket;
        this.clientNo = clientNo;
    }

    @Override
    public void run() {

        try {

            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));

            do {

                double length = dis.readDouble();
                System.out.println("从客户端" + clientNo + "接收到的边长数据为：" + length);
                double result = length * length;
                dos.writeDouble(result);
                dos.flush();

            } while (dis.readInt() != 0);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端" + clientNo + "通信结束");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
