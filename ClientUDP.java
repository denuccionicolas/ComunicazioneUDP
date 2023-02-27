import java.io.*;
import java.net.*;

public class UDPClient
{
  public static void main(String args[]) throws Exception
  {
    int portaServer = 6789;
    InetAddress IPServer = InetAddress.getByName("localhost");
    
    byte[] bufferOUT = new byte[1024];
    byte[] bufferIN = new byte[1024];
    BufferedReader input = new BufferedReader(new inputStreamReader(System.in));
    
    //creazione Socket
    DatagramSocket clientSocket = new DatagramSocket();
    System.out.println("Client pronto -Inserisci un dato da inviare:");
    
    //preparazoine del messaggio da spedire 
    String daSpedire = input readLine();
    bufferOUT = daSpedire.getBytes();
    
    //trasmissionedel dato al server
    DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.lenght, IPServer, portaServer);
    clientSocket.send(sendPacket);
    
    //ricezione del dato dal server
    DatagramPacket receivePacket = new DatagramPacket(BufferIN, bufferIN.lenght);
    clientSocket.receive(receivePacket);
    String ricevuto = new String(receivePacket.getData());
    
    //elaborando dei dati ricevuti
    int numCaratteri = receivePacket.getLength();
    ricevuto=ricevuto.substring(0,numCaratteri); //elimina i caratteri in eccesso
    System.out.println("dal Server:" + ricevuto);
    
    //termine elaborazione
    clientSocket.close();
    
  }
}
    
     
                                                                 
    
    
