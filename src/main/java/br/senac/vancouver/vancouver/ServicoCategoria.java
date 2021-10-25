package br.senac.vancouver.vancouver;

import java.util.List;
import java.util.ArrayList;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;

@Path("categoria")

public class ServicoCategoria {
	
	private static List <Categoria> lista = new ArrayList<Categoria>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirCategoria(Categoria categoria) {
		try {
			DaoCategoria.inserirCategoria(categoria);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluirCategoria(@QueryParam("id_categoria") int id_categoria) {
		try {
			DaoCategoria.excluirCategoria(id_categoria);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizarCategoria(Categoria categoria) {
		try {
			DaoCategoria.atualizarCategoria(categoria);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
