package br.senac.vancouver.vancouver;

import java.util.ArrayList;
import java.util.Iterator;
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


@Path("usuario")

public class ServicoUsuario {
	
	private static List<usuario> lista = new ArrayList<usuario>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(usuario usu) {
		try {
			DaoUsuario.inserir(usu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
