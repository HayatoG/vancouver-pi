package br.senac.vancouver.vancouver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoItem {
	
	
	public static List<Item> pesquisarItem(String nome) throws Exception {
		String sql = "SELECT * FROM item WHERE nome_item like ?;";
		
		List<Item> resultados = new ArrayList<Item>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, "%" + nome + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				
				item.setId_item(rs.getInt("id_item"));
				item.setNome_item(rs.getString("nome_item"));
				item.setPreco_item(rs.getFloat("preco_item"));
				item.setDescricao(rs.getString("descricao"));
				item.setDisponivel(rs.getBoolean("disponivel"));
				item.setFoto(rs.getString("foto"));
				item.setId_usuario(rs.getInt("id_usuario"));
				item.setId_categoria(rs.getInt("id_categoria"));
				
				resultados.add(item);
			}
		}
		
		return resultados;
	}
	

	public static void inserirItem(Item item) throws Exception {
		String sql = "INSERT INTO item (id_item, nome_item, preco_item, descricao, disponivel, foto, id_usuario, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, item.getId_item());
			ps.setString(2, item.getNome_item());
			ps.setFloat(3, item.getPreco_item());
			ps.setString(4, item.getDescricao());
			ps.setBoolean(5, item.isDisponivel());
			ps.setString(6, item.getFoto());
			ps.setInt(7, item.getId_usuario());
			ps.setInt(8, item.getId_categoria());
			
			ps.execute();
		}
	}
	
	public static void excluir(int id_item) throws Exception {
		String sql = "DELETE FROM item WHERE id_item = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, id_item);
			
			ps.execute();
		}
	}
	
	public static void atualizar(Item item) throws Exception {
		String sql = "UPDATE item SET nome_item = ?, descricao = ?, preco_item = ?, disponivel = ?, foto =  ?, id_usuario = ?, id_categoria = ? WHERE id_item = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, item.getNome_item());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco_item());
			ps.setBoolean(4, item.isDisponivel());
			ps.setString(5, item.getFoto());
			ps.setInt(6, item.getId_usuario());
			ps.setInt(7, item.getId_categoria());
			ps.setInt(8, item.getId_item());
			
			ps.execute();
			
		}
	}
	

}
