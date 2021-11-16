import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args)throws Exception{
        Scanner scan=new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket();
        while(true)
        {
            System.out.println("UDP Client message:");
            String str=scan.nextLine();
            InetAddress ip=InetAddress.getByName("localhost");
            DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),ip,9999);
            ds.send(dp);
            if(str.equals("bye"))
            {
                ds.close();
                break;
            }

        }
    }
}
