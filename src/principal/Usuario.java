package principal;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Usuario implements Runnable {

	String ip;
	Integer porta;
	Socket conexao = null;
	
	public Usuario(String ip, Integer porta) {
		this.ip = ip;
		this.porta = porta;	
	}
	
	@Override
	public void run() {		
		//Conectando ao servidor
		while(conectaServidor()==null) {	
			conectaServidor();
		}	
		System.out.println("Conectado com SUCESSO.\nJá é possível enviar mensagens");
		enviarMensagem();
		
		try {
			conexao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket conectaServidor(){
		
		//Tenta conexão com o servidor
		try {
			System.out.println("Tentou");
			conexao = new Socket(ip,porta);
		} catch (UnknownHostException e) {
			System.out.println("Servidor não encontrando. Tentando nova conexão");
		} catch (IOException e) {
			System.out.println("Servidor não encontrando. Tentando nova conexão");
		}
		
		return conexao;
	}
	
	public void enviarMensagem(){
		Scanner s = new Scanner(System.in);
		PrintStream out = null;
		
		try {
			out = new PrintStream(conexao.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(s.hasNextLine()) {
			out.println(s.nextLine());
		}
		
		s.close();
		out.close();
	}
	
}
