package classes_de_conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class acoes {

	private int id;
	private String usuario;
	private String email;
	private String senha;
	
	public acoes(int id_p) {
		
		this.id = id_p;
		
	}
	
	public acoes(String us, String em, String se) {
		
		this.usuario = us;
		this.email = em;
		this.senha = se;
	}
	
	public acoes(int id_p, String us, String em, String se) {	
		
		this.id = id_p;
		this.email = em;
		this.usuario = us;
		this.senha = se;
	}

	
	//Inicio - Metodo Salvar

	public void salvar () {
		
		try {
			Connection con = Conexao.faz_conexao();
			String sql ="insert into dados_senhas(usuario, senha, email) values(?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			stmt.setString(1, usuario);
			stmt.setString(2, email);
			stmt.setString(3, senha);
			stmt.execute();
			
			
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Usuario cadastrado!!!");
			
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	//Fim - Metodo Salvar

	
	//Inicio - Metodo Atualizar
	public void atualizar () {
		
		try {
			Connection con = Conexao.faz_conexao();
			String sql = "update dados_senhas set usuario=?, email=?, senha=? where id=?";

			
			PreparedStatement stmt = con.prepareStatement(sql);
			

			stmt.setString(1, usuario);
			stmt.setString(2, email);
			stmt.setString(3, senha);
			stmt.setInt(4, id);
			

			stmt.execute();
			
			stmt.close();
			con.close();

			
			JOptionPane.showMessageDialog(null, "Usuario atualizado!");
				

		} catch (SQLException e1) {
			e1.printStackTrace();

		}	
				
		
	}
	
}
