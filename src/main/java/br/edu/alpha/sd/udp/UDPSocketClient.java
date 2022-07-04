package br.edu.alpha.sd.udp;

import java.io.*;
import java.net.*;

public class UDPSocketClient {
	public static String URL = "localhost";
	public static int PORT = 6000;

	public static void main(String[] args) {
		String msg = "Testando conexao.";
		try {	
			InetAddress addr = InetAddress.getByName(URL);
			//Monta o datagrama
			byte [] msgByte = msg.getBytes(); 
			DatagramPacket pkg = new DatagramPacket(msgByte,msg.length(), addr, PORT);
			// Cria o DatagramSocket que será responsável por enviar a mensagem
			DatagramSocket ds = new DatagramSocket();
			//Envia a mensagem
			ds.send(pkg);
			System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n" +
					"Porta: " + PORT + "\n" + "Mensagem: " + msg);

			//Fecha o DatagramSocket
			ds.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}	
}
