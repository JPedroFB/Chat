package principal;

import java.io.IOException;
import redes.Servidor;
import view.JanelaChat;
import view.JanelaDeConexao;

public class Main {
	public static void main(String[] args) throws IOException {
		String ip = null;
		Integer porta = null;

		
		Thread servidor = new Thread(new Servidor());
		servidor.start();	
		
		// Instancia janela de conexao
		JanelaDeConexao jconect = new JanelaDeConexao();
		jconect.setVisible(true);
		
		// Recebe parametros IP e Porta de conexao
		while(jconect.getStatus()!=true) {
			System.out.println("Passou");
			ip = jconect.getIp();
			porta = jconect.getPorta();
		}
		
		// Intancia janela chat
		JanelaChat jchat = new JanelaChat();
		jchat.setVisible(true);
		
		Thread usuario =  new Thread(new Usuario(ip,porta));		
		usuario.start();
			
		
	}
}
