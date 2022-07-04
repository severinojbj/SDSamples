package br.edu.alpha.sd.tcp;
import java.net.*;
import java.io.*;

public class TCPSocketServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket (6000);
			Socket socket = server.accept();
			InputStream input = socket.getInputStream();
			BufferedReader buffer = new BufferedReader (new InputStreamReader(input));
			String strLine = buffer.readLine();
			System.out.println (strLine);
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //socket port 
	}

}
