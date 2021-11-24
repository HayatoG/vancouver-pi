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

@Path("item")

public class ServicoItem {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirItem(Item item) {
		try {
			DaoItem.inserirItem(item);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id_item") int id_item) {
		try {
			DaoItem.excluir(id_item);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Item item) {
		try {
			DaoItem.atualizar(item);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Item> pesquisarItem(@QueryParam("nome_item") String nome_item) {
		try {
			return DaoItem.pesquisarItem(nome_item);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
