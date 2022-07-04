package br.edu.alpha.sd.udp;

import java.io.*;
import java.net.*;

public class UDPSocketServer {
	public static String URL = "localhost";
	public static int PORT = 6000;
	
	public static void main (String [] args) {
		
		 try {
		        //Cria o DatagramSocket para aguardar mensagens, neste momento o método fica bloqueando
		        //até o recebimente de uma mensagem
		        DatagramSocket ds = new DatagramSocket(PORT);
		        System.out.println("Ouvindo a porta: " + PORT);
		        //Preparando o buffer de recebimento da mensagem
		        byte[] msg = new byte[256];
		        //Prepara o pacote de dados
		        DatagramPacket pkg = new DatagramPacket(msg, msg.length);
		        //Recebimento da mensagem
		        ds.receive(pkg);
		        String dataReceive = new String (pkg.getData());
		        System.out.println(dataReceive);
		        ds.close();
		      }

		      catch(IOException ioe) {
		    	  ioe.printStackTrace();
		      }
	}
}
