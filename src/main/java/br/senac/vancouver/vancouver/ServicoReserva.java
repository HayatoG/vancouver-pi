package br.senac.vancouver.vancouver;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("reserva")

public class ServicoReserva {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirReserva(Reserva reserva) {
		try {
			DaoReserva.inserirReserva(reserva);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id_reserva") int id_reserva) {
		try {
			DaoReserva.excluir(id_reserva);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Reserva reserva) {
		try {
			DaoReserva.atualizar(reserva);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> listarReserva(){
		try {
			return DaoReserva.listarReserva();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}