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

public class Tela_de_cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JButton btnSalvar;
	private JPanel panel_1;
	private JButton btnAbrir;
	private JTextField tfBusca;
	private JScrollPane scrollPane;
	private JTable tbDados;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JMenuBar menuBar;
	private JMenuItem mntmAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_cadastro frame = new Tela_de_cadastro();
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
	public Tela_de_cadastro() {
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
				
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Usuario/senha em branco.");
					
				} else {
					
					acoes ac = new acoes(tfUsuario.getText(), tfSenha.getText() );
					
					ac.salvar();
					
					tfUsuario.setText("");
					tfSenha.setText("");
				}
				
				
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArquivos.add(mntmSalvar);
		
		mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Usuario/senha em branco.");
					
				} else {
				acoes ac = new acoes(Integer.parseInt(tfID.getText()), tfUsuario.getText(), tfSenha.getText());
				
				ac.atualizar();
				}
				
				tfUsuario.setText("");
				tfSenha.setText("");
			}
		});
		mntmAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArquivos.add(mntmAtualizar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.RED);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID.setBounds(23, 37, 69, 26);
		contentPane.add(lblID);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.RED);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(23, 74, 69, 26);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(23, 115, 69, 26);
		contentPane.add(lblSenha);
		
		tfID = new JTextField();
		tfID.setEnabled(false);
		tfID.setBounds(102, 41, 93, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(102, 78, 184, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(102, 119, 184, 20);
		contentPane.add(tfSenha);
		tfSenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 245, 414, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Usuario/senha em branco.");
					
				}
				
					
				try {
					Connection con = Conexao.faz_conexao();
					String sql ="insert into senhas_dados(usuario, senha) values(?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, tfSenha.getText());
					
					stmt.execute();
					
					
					stmt.close();
					
					JOptionPane.showMessageDialog(null, "Usuario cadastrado!!!");
					
					tfUsuario.setText("");
					tfSenha.setText("");
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSalvar.setBounds(10, 17, 89, 23);
		panel.add(btnSalvar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Abra os dados para realizar alterações");

				}else {

					try {
					Connection con = Conexao.faz_conexao();
					String sql = "update senhas_dados set usuario=?, senha=? where id=?";

					
					PreparedStatement stmt = con.prepareStatement(sql);
					

					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2,tfSenha.getText());
					stmt.setString(3, tfID.getText());
					

					stmt.execute();
					stmt.close();
					con.close();

					
					JOptionPane.showMessageDialog(null, "Usuario atualizado!");

					
					stmt.close();
					con.close();

								

					tfUsuario.setText("");
					tfSenha.setText("");
					tfID.setText("");
				

				} catch (SQLException e1) {
					e1.printStackTrace();

				}	
						

				}
				
			}
		});
		btnAtualizar.setBounds(124, 17, 89, 23);
		panel.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tfID.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Informe o ID");

				}else {
				
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql= "delete from senhas_dados where id=?";
					
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfID.getText());
							
					stmt.execute();
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Excluido!");
					
					tfUsuario.setText("");
					tfSenha.setText("");
					tfID.setText("");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}};
		});
		btnExcluir.setBounds(236, 17, 89, 23);
		panel.add(btnExcluir);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Abrir dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(23, 326, 411, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfBusca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo busca em branco!");

				}else {

				try {

					Connection con = Conexao.faz_conexao();
					String sql = "select *from senhas_dados where id like ? ";

					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, "%"+ tfBusca.getText());
					
					ResultSet rs = stmt.executeQuery();
					

					while (rs.next()) {

					
						tfID.setText(rs.getString("id"));
						tfUsuario.setText(rs.getString("usuario"));
						tfSenha.setText(rs.getString("senha"));
					}
						
					rs.close();
					con.close();
							

				} catch (SQLException e1) {
					e1.printStackTrace();

				}	

				}
				
				
			}
			
			
		});
		btnAbrir.setBounds(10, 17, 89, 23);
		panel_1.add(btnAbrir);
		
		tfBusca = new JTextField();
		tfBusca.setBounds(114, 18, 86, 22);
		panel_1.add(tfBusca);
		tfBusca.setColumns(10);
		
		JButton btnListarDados = new JButton("Listar dados");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = Conexao.faz_conexao();

					String sql = "select *from senhas_dados";

					

					PreparedStatement stmt = con.prepareStatement(sql);

							

					ResultSet rs = stmt.executeQuery();



					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();

					modelo.setNumRows(0);

					while (rs.next()) {

					

						

						modelo.addRow(new Object[]{rs.getString("id"), rs.getString("usuario"), rs.getString("senha")});

						

					}

					

					

					

					rs.close();

					con.close();

			

				} catch (SQLException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}	

			

		}});
		btnListarDados.setBounds(291, 17, 110, 23);
		panel_1.add(btnListarDados);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 152, 414, 88);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Usuario", "Senha"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tbDados);
	}
}
