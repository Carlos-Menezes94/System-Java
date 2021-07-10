package classes_de_conexao;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		tfUsuario.setBounds(147, 48, 190, 39);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(147, 127, 190, 39);
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

						
						Tela_de_cadastro exibir = new Tela_de_cadastro ();
						exibir.setVisible(true);
						
						setVisible(false);
					}else {

						JOptionPane.showMessageDialog(null, "Usuario/Senha incorreto :(");

					}

					

					stmt.close();
					con.close();

									

				} catch (SQLException e1) {
					e1.printStackTrace();

				}
			}
		});
		btnEntrar.setBounds(180, 239, 116, 28);
		contentPane.add(btnEntrar);
	}
}
