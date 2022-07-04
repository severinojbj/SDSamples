package br.edu.alpha.sd.tcp;
import java.net.*;
import java.io.*;

public class TCPSocketClient {
	public static void main(String[] args) {
		Socket client = null; 
		try {
			client = new Socket("localhost", 6000);
			OutputStream output = client.getOutputStream();
			PrintWriter sendData = new PrintWriter(output, true);
			sendData.println ("Testando conexao.");
			System.out.println ("Mensagem enviada...");
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
