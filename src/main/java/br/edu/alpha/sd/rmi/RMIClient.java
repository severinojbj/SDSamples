package br.edu.alpha.sd.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient extends UnicastRemoteObject {

	private static final long serialVersionUID = 2L;

	public static int PORT = 1099;
	
	protected RMIClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String [] args) {
		String serverName = "Servidor";
		try {
			Registry registry = LocateRegistry.getRegistry(PORT);
			IRMIServer skeleton = (IRMIServer) registry.lookup(serverName);
			String resp = skeleton.printMessage ("Testando servidor...");
			System.out.println (resp);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
