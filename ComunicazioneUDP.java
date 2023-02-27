/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;
/**
 *
 * @author DenuccioNicolas
 */
public class UDPServer{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exeption {
        // TODO code application logic here
        DatagramSocket serverSocket = new DatagramSocket(6789);             // per la ripetizione del servizio
        boolean attivo = true;                                              // buffer spedizione a ricezione
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];
        
        System.out.println("SERVER AVVIATO...");
        while(attivo){
            //definizione del datagramma
            DatagramPocket receivePacket = new DatagramPacket(bufferIN, bufferOUT.lenght);
            //attesa della ricezione dato dal client
        
            serverSocket.receive(receivePacket);
        
            //analisi del pacchetto ricevuto
            String ricevuto = new String(receivePacket.getData());
            int numeCaratteri = receivePacket.getLenght();
            ricevuto = ricevuto.substring(0, numCaratteri); //elimina i caratteri in eccesso
            System.out.println("RICEVUTO: " + ricevuto);
        
            //riconoscimento dei parametri del Socket del client
            InetAddress IPClient = receivePacket.getAddress();
            int portaClient = receivePacket.getPort();
        
            //preparo il dato da spedire
            String daSpedire = ricevuto.toUpperCase();
            bufferOUT = daSpedire.getBytes();
        
            //invio del Datagramma
            DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.lenght, IPClient, portaClient);
            serverSocket.send(sendPacket);
        
            //controllo termine esecuzione del server
            if(ricevuto.equals("fine"))
            {
                System.out.println("SERVER IN CHIUSURA. Buona serata.");
                attivo=false;
            }
        }
        serverSocket.close();
    }
    
}
