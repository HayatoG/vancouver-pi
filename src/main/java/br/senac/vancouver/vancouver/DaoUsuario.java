package br.senac.vancouver.vancouver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DaoUsuario {

	public static void inserir(usuario usu) throws Exception {
		String sql = "INSERT INTO usuario (id_usuario,nome_usuario,cpf,telefone,endereco,email,login,senha) VALUES(?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ps.setInt(1, usu.getId_usuario());
				ps.setString(2, usu.getNome_usuario());
				ps.setString(3, usu.getCpf());
				ps.setString(4, usu.getTelefone());
				ps.setString(5, usu.getEndereco());
				ps.setString(6, usu.getEmail());
				ps.setString(7, usu.getLogin());
				ps.setString(8, usu.getSenha());
				
				ps.execute();
		}
	}
	
	
	public static List<usuario> listar() throws Exception{
		String sql = "select * from usuario;";
		
		List<usuario> resultados = new ArrayList<usuario>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario usu = new usuario();
				
				usu.setId_usuario(rs.getInt("id_usuario"));
				usu.setNome_usuario(rs.getString("nome_usuario"));
				usu.setCpf(rs.getString("cpf"));
				usu.setTelefone(rs.getString("telefone"));
				usu.setEndereco(rs.getString("endereco"));
				usu.setEmail(rs.getString("email"));
				usu.setLogin(rs.getString("login"));
				usu.setSenha(rs.getString("senha"));
				
				resultados.add(usu);
			}
		}
		return resultados;
	}
	
	
	public static void atualizar(usuario usu)throws Exception {
		String sql = "UPDATE usuario SET nome_usuario = ?, cpf = ?, telefone = ?, endereco = ?, email = ?, login = ?, senha = ? WHERE id_usuario = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, usu.getNome_usuario());
			ps.setString(2, usu.getCpf());
			ps.setString(3, usu.getTelefone());
			ps.setString(4, usu.getEndereco());
			ps.setString(5, usu.getEmail());
			ps.setString(6, usu.getLogin());
			ps.setString(7, usu.getSenha());
			ps.setInt(8, usu.getId_usuario());
			
			ps.execute();
		}
	}
	
	
	public static void excluir(int id_usuario) throws Exception {
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, id_usuario);
			
			ps.execute();
		}
	}
	
	
	
}

