package br.edu.alpha.sd.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements IRMIServer {

	public static int PORT = 1099;
	
	protected RMIServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String printMessage (String msg) throws RemoteException {
		System.out.println (msg);
		return "Mensagem " + msg + " enviada!";
	}
	
	public static void main (String [] args) {		
		try {
			IRMIServer server = new RMIServer();
			IRMIServer stub = (IRMIServer) UnicastRemoteObject
			  .exportObject((IRMIServer) server, 0);
			Registry registry = LocateRegistry.createRegistry(PORT);
			registry.rebind("Servidor", stub);
			System.out.println ("Server started at port: " + PORT);
			
		}
		catch (RemoteException e) {
			System.out.println ("Remote Exception");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
