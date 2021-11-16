import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",1234);
        DataOutputStream dout= new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("TCP Client message: ");
            String so = br.readLine();
            dout.writeUTF(so);
            if(so.equalsIgnoreCase("bye")){
                break;
            }
        }
        s.close();
    }
}
