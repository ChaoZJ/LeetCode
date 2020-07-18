package solution;

import java.io.*;
import java.lang.reflect.Field;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author ZhangChao
 * @since 2020/5/28
 */
public class ArrUtil {
    public static void print2Array(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(String.valueOf(array[i][j]) + ',');
            }
            System.out.println();
        }
        System.out.println("=================================");
    }

    public static void main(String[] args) throws IOException {
        ArrUtil[] arrUtils = new ArrUtil[10];
        for (Field field : arrUtils.getClass().getFields()){
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }
}
