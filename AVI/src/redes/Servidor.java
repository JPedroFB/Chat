package redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor implements Runnable {
	
	ServerSocket server;
	Socket cliente;
	
	public void run() {
		abreConexao();
		buscaCliente();
		recebeMensagem();
	}
	
	public void abreConexao(){
		try {
			server = new ServerSocket(1010);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Porta 10000 aberta, aguardando conexão!");
	}
	
	public void buscaCliente(){
		try {
			cliente = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Conexão do cliente "+cliente.getInetAddress().getHostAddress());
	}
	
	public void recebeMensagem(){
		Scanner s = null;
		try {
			s = new Scanner(cliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
	}
}