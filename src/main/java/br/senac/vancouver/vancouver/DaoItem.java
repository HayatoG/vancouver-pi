package br.senac.vancouver.vancouver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoItem {
	

	public static void inserirItem(Item item) throws Exception {
		String sql = "INSERT INTO item (id_item, nome_item, preco_item, descricao, disponivel) VALUES (?, ?, ?, ?, ?)";
	
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, item.getId_item());
			ps.setString(2, item.getNome_item());
			ps.setFloat(3, item.getPreco_item());
			ps.setString(4, item.getDescricao());
			ps.setBoolean(5, item.isDisponivel());
			
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
			ps.setFloat(3, item.getPreco_item());
			ps.setBoolean(4, item.isDisponivel());
			
			ps.execute();
			
		}
	}
	

}
