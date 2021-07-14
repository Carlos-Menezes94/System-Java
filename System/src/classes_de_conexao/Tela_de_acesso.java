package classes_de_conexao;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_acesso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnRecuperarSenha;
	private JLabel lblNoPossuiCadastro;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	

	
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_acesso frame = new Tela_de_acesso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



public void disposeJFrame(JFrame frame){
    frame.setVisible(false);
    frame.dispose();
}
	
	/**
	 * Create the frame.
	 */
	public Tela_de_acesso() {
		setResizable(false);
		setTitle("Tela de acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.RED);
		lblUsuario.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblUsuario.setBounds(25, 36, 99, 60);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblSenha.setBounds(25, 127, 99, 60);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(147, 53, 190, 28);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(147, 138, 190, 28);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection con = Conexao.faz_conexao();
					String sql = "select *from dados_senhas where usuario=? and senha=?";

					

					PreparedStatement stmt = con.prepareStatement(sql);

					
					stmt.setString(1, tfUsuario.getText());
					String captura = new String(pfSenha.getPassword());
					stmt.setString(2, captura);

					

					ResultSet rs = stmt.executeQuery();

					
					if(rs.next()) {

						
						Tela_home exibir = new Tela_home ();
						exibir.setVisible(true);
						Tela_de_acesso.this.dispose();
						
						
						setVisible(false);
					}else {

						JOptionPane.showMessageDialog(null, "Usuario/Senha incorreto :(", captura, JOptionPane.ERROR_MESSAGE);

					}

					

					stmt.close();
					con.close();

									

				} catch (SQLException e1) {
					e1.printStackTrace();

				}
			}
		});
		btnEntrar.setBounds(177, 208, 116, 28);
		contentPane.add(btnEntrar);
		
		btnRecuperarSenha = new JButton("Recuperar senha");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_recuperacao exibir = new Tela_de_recuperacao ();
				exibir.setVisible(true);
			
			}
		});
		btnRecuperarSenha.setBounds(291, 330, 116, 28);
		contentPane.add(btnRecuperarSenha);
		
		lblNoPossuiCadastro = new JLabel("N\u00E3o possui cadastro? clique logo abaixo para se cadastrar!");
		lblNoPossuiCadastro.setForeground(Color.RED);
		lblNoPossuiCadastro.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 9));
		lblNoPossuiCadastro.setBounds(10, 278, 271, 60);
		contentPane.add(lblNoPossuiCadastro);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_cadastro exibir = new Tela_cadastro ();
				exibir.setVisible(true);
			}
		});
		btnCadastrar.setBounds(8, 330, 116, 28);
		contentPane.add(btnCadastrar);
	}
}


