package classes_de_conexao;

import java.awt.Button;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class acoes {

	private int id;
	private String usuario;
	private String email;
	private String senha;
	private Button btnCancel;
	
	
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

	
	  public static void main(String args []) throws NoSuchAlgorithmException,
	   UnsupportedEncodingException {

	       String senha = "admin";

	       MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	       byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

	       StringBuilder hexString = new StringBuilder();
	       for (byte b : messageDigest) {
	         hexString.append(String.format("%02X", 0xFF & b));
	       }
	       String senhahex = hexString.toString();

	       System.out.println(senhahex);
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
	
	
	public void logout () {
		

	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}
	
}
