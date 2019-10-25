package principal;

import java.io.IOException;
import java.util.Scanner;

import redes.Servidor;

public class Main {
	public static void main(String[] args) throws IOException {
		String ip;
		Integer porta;
		
		
		System.out.println("Por padrão, a porta deste serviço é 1010\n");
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o ip do servidor à se conectar");
		ip = s.nextLine();

		System.out.println("Digite a porta do servidor "+ip);
		porta = s.nextInt();

		Thread usuario =  new Thread(new Usuario(ip,porta));
		Thread servidor = new Thread(new Servidor());
		
		usuario.start();
		servidor.start();		
		
	}
}
