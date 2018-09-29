import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by Yan_Jiang on 2018/9/29.
 * NIO示例
 */
public class ChannelDemo {

    public static void main(String[] args) {

        File fileIn = new File("F:/idea-project/NIO/test/inText.txt");
        File fileOut = new File("F:/idea-project/NIO/test/OutText.txt");

        WritableByteChannel writeChannel = null;
        ReadableByteChannel readChannel = null;

        try {
            FileInputStream in = new FileInputStream(fileIn); //读取文件
            readChannel = in.getChannel(); //获取读通道

            FileInputStream out = new FileInputStream(fileOut); //读取文件
            writeChannel = out.getChannel(); //获取写通道

            copyData(readChannel, writeChannel); //拷贝数据


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writeChannel != null) {
                    writeChannel.close();
                }
                if (readChannel != null) {
                    readChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Copy Data finished.");
        }


    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest)  {

        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
        try {
            while (src.read(buffer) != -1) {
                // The buffer is used to drained
                buffer.flip();
                // keep sure that buffer was fully drained
                while (buffer.hasRemaining()) {
                    dest.write(buffer);
                }
                buffer.clear(); // Now the buffer is empty, ready for the filling
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
