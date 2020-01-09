package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaChat extends JFrame {

	private JPanel contentPane;
	private JTextField textTeclado;
	private JTextPane textPane;

	public JanelaChat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			textPane.setText(textPane.getText()+"\n"+textTeclado.getText());
			textTeclado.setText("");	
			}
		});
		btnEnviar.setBounds(172, 263, 89, 23);
		contentPane.add(btnEnviar);
		
		textTeclado = new JTextField();
		textTeclado.setBounds(10, 207, 251, 45);
		contentPane.add(textTeclado);
		textTeclado.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 251, 185);
		contentPane.add(textPane);
	}
	
	public void escrever(String msg) {
		textPane.setText(msg);
	}

}
