package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class JanelaDeConexao extends JFrame {

	private JPanel contentPane;
	private JTextField textIp;
	private JTextField textPorta;
	private JTextPane textPane;

	String ip;
	Integer porta;
	boolean status;
	
	public JanelaDeConexao() {
		setBounds(100, 100, 463, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIp = new JTextField();
		textIp.setBounds(10, 57, 207, 33);
		contentPane.add(textIp);
		textIp.setColumns(10);
		
		JButton btnEnviar = new JButton("Conectar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ip = textIp.getText();
				porta = Integer.parseInt(textPorta.getText());
				status = true;
			}
		});
		
		
		btnEnviar.setBounds(77, 178, 89, 23);
		contentPane.add(btnEnviar);
		
		textPorta = new JTextField();
		textPorta.setBounds(10, 116, 207, 33);
		contentPane.add(textPorta);
		textPorta.setColumns(10);
		
		JLabel lblIp = new JLabel("Ip");
		lblIp.setBounds(10, 32, 46, 14);
		contentPane.add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setBounds(10, 101, 46, 14);
		contentPane.add(lblPorta);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(249, 11, 171, 207);
		contentPane.add(textPane);
	}
	
	
	public String getIp() {
		return ip;
	}
	
	public Integer getPorta() {
		return porta;
	}
	
	public boolean getStatus() {
		return status;
	}
	
}
