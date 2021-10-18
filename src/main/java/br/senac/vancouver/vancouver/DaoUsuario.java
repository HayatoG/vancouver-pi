package br.senac.vancouver.vancouver;

import java.sql.PreparedStatement;


public class DaoUsuario {

	public static void inserir(usuario usu) throws Exception {
		String sql = "INSERT INTO usuario (id_usuario,nome_usuario,cpf,telefone,endereco,email,login,senha) VALUES(?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ps.setInt(1, usu.getId_usuario());
				ps.setString(2, usu.getNome_usuario());
				ps.setInt(3, usu.getCpf());
				ps.setInt(4, usu.getTelefone());
				ps.setString(5, usu.getEndereco());
				ps.setString(6, usu.getEmail());
				ps.setString(7, usu.getLogin());
				ps.setString(8, usu.getSenha());
				
				ps.execute();
		}
	}
	
	
	
	
	
}

