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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Tela_cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JButton btnSalvar;
	private JMenuBar menuBar;
	private JMenuItem mntmAtualizar;
	private JLabel lblEmail;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
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
	public Tela_cadastro() {
		setTitle("Cadastro de usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 439);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivos = new JMenu("Arquivos");
		menuBar.add(mnArquivos);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				

				if (tfUsuario.getText().equals("") || tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Usuario/senha em branco.");
					
				}
				
					
				try {
					Connection con = Conexao.faz_conexao();
					String sql ="insert into dados_senhas(usuario, email, senha) values(?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, tfUsuario.getText());

					stmt.setString(2, tfEmail.getText());
					stmt.setString(3, tfSenha.getText());
					
					stmt.execute();
					
					
					stmt.close();
					
					JOptionPane.showMessageDialog(null, "Usuario cadastrado!!!");
					
					tfUsuario.setText("");
					
					tfEmail.setText("");
					tfSenha.setText("");

					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArquivos.add(mntmSalvar);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.RED);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(23, 74, 69, 26);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(23, 172, 69, 26);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(102, 78, 184, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(23, 125, 69, 26);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(102, 129, 184, 20);
		contentPane.add(tfEmail);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(102, 176, 184, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 326, 414, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUsuario.getText().equals("") || tfEmail.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Usuario/Email/Senha em branco.");
					
				}
				
					
				try {
					Connection con = Conexao.faz_conexao();
					String sql ="insert into dados_senhas(usuario, email, senha) values(?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, tfEmail.getText());
					stmt.setString(3, tfSenha.getText());
					
					stmt.execute();
					
					
					stmt.close();
					
					JOptionPane.showMessageDialog(null, "Usuario cadastrado!!!");
					
					tfUsuario.setText("");
					tfEmail.setText("");
					tfSenha.setText("");
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSalvar.setBounds(10, 17, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnVoltarAcesso = new JButton("Voltar");
		btnVoltarAcesso.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_acesso exibir = new Tela_de_acesso ();
				exibir.setVisible(true);
				Tela_cadastro.this.dispose();
			}
		});
		btnVoltarAcesso.setBounds(315, 17, 89, 23);
		panel.add(btnVoltarAcesso);
		
		JLabel lblText = new JLabel("Preencha os campos com seus dados.");
		lblText.setForeground(Color.RED);
		lblText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblText.setBounds(56, 11, 291, 26);
		contentPane.add(lblText);
		
		
		
		
	}
}
