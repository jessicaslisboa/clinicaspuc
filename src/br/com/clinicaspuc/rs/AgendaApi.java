package br.com.clinicaspuc.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.clinicaspuc.model.Agenda;

@Path("/agenda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendaApi {
	
	@GET
	@Path("{codUsuario}")
	public List<Agenda> getAgenda(@QueryParam("codUsuario") int codUsuario){
		return null;
	}
	
	@POST
	public Agenda salvar(Agenda agenda) {
		return agenda;
	}
	
	@PUT
	public void atualizar(Agenda agenda) {
		
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		
	}
	
}
