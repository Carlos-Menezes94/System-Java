package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;

public class Tela_home extends JFrame {

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
					Tela_home frame = new Tela_home();
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
	public Tela_home() {
		setTitle("Pagina Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtualizarDados = new JButton("Atualizar dados");
		btnAtualizarDados.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_de_atualizacao exibir = new Tela_de_atualizacao ();
				exibir.setVisible(true);
				
			}
		});
		btnAtualizarDados.setBounds(10, 227, 123, 23);
		contentPane.add(btnAtualizarDados);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(220, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(319, 227, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblBemvindo = new JLabel("Bem vindo,");
		lblBemvindo.setForeground(Color.RED);
		lblBemvindo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblBemvindo.setBounds(22, 11, 96, 43);
		contentPane.add(lblBemvindo);
	}
}



