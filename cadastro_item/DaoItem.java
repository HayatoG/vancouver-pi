package br.senac.vancouver.pi.cadastro_item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoItem {
	

	public static void inserir(Item item) throws Exception {
		String sql = "INSERT INTO item (nome_item, descricao, preco, status) VALUES (?, ? ? ?)";
	
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, item.getNome_item());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setBoolean(4, item.getStatus());
			
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
		String sql = "UPDATE item SET nome_item = ?, descricao = ?, preco = ? status = ? WHERE id_item = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, item.getNome_item());
			ps.setString(2, item.getDescricao());
			ps.setFloat(3, item.getPreco());
			ps.setBoolean(4, item.getStatus());
			
			ps.execute();
			
		}
	}
	
	public static List<Item> pesquisar(String nome_item) throws Exception {
		String sql = "SELECT * FROM item WHERE nome_item LIKE ?";
		
		List<Item> result = new ArrayList<Item>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, "%" + nome_item + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				
				item.setId(rs.getInt("id_item"));
				item.setNome_item(rs.getString("nome_item"));
				item.setPreco(rs.getFloat("preco"));
				item.setStatus(rs.getBoolean("status"));
				item.setDescricao(rs.getString("descricao"));
				
				result.add(item);
				
			}
		}
		
		return result;
	}

}
