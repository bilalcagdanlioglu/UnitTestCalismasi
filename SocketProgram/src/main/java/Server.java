import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //TCP SERVER
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket=new ServerSocket(1234);
                    Socket socket=serverSocket.accept();
                    Scanner scan=new Scanner(System.in);
                    DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
                    DataInputStream dis=new DataInputStream(socket.getInputStream());
                    while(true)
                    {
                        String str=dis.readUTF();
                        txtWriter("Client TCP Message : "+ str);
                        System.out.println("Client TCP: "+str);
                        if(str.equals("exit"))
                        {
                            System.out.println("TCP CLIENT IS CLOSING");
                            dis.close();
                            socket.close();
                            serverSocket.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //UDP SERVER
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket datagramSocket=new DatagramSocket(9999);
                    byte[] buff=new byte[1024];
                    while(true){
                        DatagramPacket packet=new DatagramPacket(buff,buff.length);
                        datagramSocket.receive(packet);
                        String str=new String(packet.getData(),0,packet.getLength());
                        txtWriter("Client UDP Message : "+ str);
                        System.out.println("Client UDP: "+str);
                        if(str.equals("exit"))
                        {
                            System.out.println("UDP CLIENT IS CLOSING");
                            break;
                        }
                        buff=new byte[1024];
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public synchronized static void txtWriter(String str) throws IOException {
        File file = new File("server.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str+"\n");
        bWriter.close();
    }
}
