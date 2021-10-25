package br.senac.vancouver.vancouver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoReserva {
	

	public static void inserirReserva(Reserva reserva) throws Exception{
		String sql = "INSERT INTO reserva (id_reserva, preco_reserva, data_reserva, data_devolucao) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, reserva.getId_reserva());
			ps.setFloat(2, reserva.getPreco_reserva());
			ps.setString(3, reserva.getData_reserva());
			ps.setString(4, reserva.getData_devolucao());
		
			
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
				ps.setString(2, reserva.getData_reserva());
				ps.setString(3, reserva.getData_devolucao());
				
				ps.execute();
				
			}
		}
		
		public static List<Reserva> pesquisarReserva(String id_reserva) throws Exception {
			String sql = "SELECT * FROM reserva WHERE id_reserva like ?";
			
			List<Reserva> resultados = new ArrayList<Reserva>();
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
				ps.setString(1, id_reserva);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Reserva reserva = new Reserva();
					
					reserva.setId_reserva(rs.getInt("id_reserva"));
					reserva.setPreco_reserva(rs.getFloat("preco_reserva"));
					reserva.setData_reserva(rs.getString("data_reserva"));
					reserva.setData_devolucao(rs.getString("data_devolucao"));
					
					resultados.add(reserva);
				}
			}
			
			return resultados;
		}
}
