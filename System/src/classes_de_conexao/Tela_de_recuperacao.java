package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_de_recuperacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_recuperacao frame = new Tela_de_recuperacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_de_recuperacao() {
		setTitle("Recupera\u00E7\u00E3o de senha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Recuperar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(35, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltarAcesso = new JButton("Voltar");
		btnVoltarAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_acesso exibir = new Tela_de_acesso ();
				exibir.setVisible(true);
				Tela_de_recuperacao.this.dispose();

			
				
			}
		});
		btnVoltarAcesso.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltarAcesso);
	}
}
