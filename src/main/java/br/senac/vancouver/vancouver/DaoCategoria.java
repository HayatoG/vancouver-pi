package br.senac.vancouver.vancouver;

import java.sql.PreparedStatement;


public class DaoCategoria {

	public static void inserirCategoria(Categoria categoria) throws Exception {
		String sql = "INSERT INTO categoria (id_categoria, nome_categoria) VALUES (?, ?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ps.setInt(1, categoria.getId_categoria());
				ps.setString(2, categoria.getNome_categoria());
				
				ps.execute();
		}
	}
	
	
	public static void atualizarCategoria(Categoria categoria)throws Exception {
		String sql = "UPDATE categoria SET nome_categoria = ? WHERE id_categoria = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, categoria.getNome_categoria());
			ps.setInt(2, categoria.getId_categoria());
			
			ps.execute();
		}
	}
	
	
	public static void excluirCategoria(int id_categoria) throws Exception {
		String sql = "DELETE FROM categoria WHERE id_categoria = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, id_categoria);
			
			ps.execute();
		}
	}
	
	
}

