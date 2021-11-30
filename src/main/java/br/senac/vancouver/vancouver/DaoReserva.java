package br.senac.vancouver.vancouver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoReserva {
	

	public static void inserirReserva(Reserva reserva) throws Exception{
		String sql = "INSERT INTO reserva (id_reserva, preco_reserva, data_reserva, data_devolucao, id_usuario, id_item) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, reserva.getId_reserva());
			ps.setFloat(2, reserva.getPreco_reserva());
			ps.setDate(3, java.sql.Date.valueOf(reserva.getData_reserva()));
			ps.setDate(4, java.sql.Date.valueOf(reserva.getData_devolucao()));
			ps.setInt(5, reserva.getId_usuario());
			ps.setInt(6, reserva.getId_item());
		
			ps.execute();
		}
	}
	
		public static void excluir(int id_reserva) throws Exception{
			String sql = "DELETE FROM reserva WHERE id_reserva = ?";
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
				ps.setInt(1, id_reserva);
				
				ps.execute();
			}
		}
		
		public static void atualizar(Reserva reserva) throws Exception {
			String sql = "UPDATE reserva SET preco_reserva = ?, data_reserva = ?, data_devolucao = ? where id_reserva = ?";
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ps.setFloat(1, reserva.getPreco_reserva());
				ps.setDate(2, java.sql.Date.valueOf(reserva.getData_reserva()));
				ps.setDate(3, java.sql.Date.valueOf(reserva.getData_devolucao()));
				ps.setInt(4, reserva.getId_reserva());
				
				ps.execute();
				
			}
		}
		
		
		public static List<Reserva> listarReserva() throws Exception {
			String sql = "SELECT * FROM reserva;";
			
			List<Reserva> resultados = new ArrayList<Reserva>();
			
			try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()) {
					Reserva reserva = new Reserva();
					
					reserva.setId_reserva(rs.getInt("id_reserva"));
					reserva.setPreco_reserva(rs.getFloat("preco_reserva"));
					reserva.setData_reserva(rs.getDate("data_reserva").toLocalDate());
					reserva.setData_devolucao(rs.getDate("data_devolucao").toLocalDate());
					reserva.setId_usuario(rs.getInt("id_usuario"));
					reserva.setId_item(rs.getInt("id_item"));
					
					resultados.add(reserva);
				}
			}
			
			return resultados;
		}
		
}