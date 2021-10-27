package br.com.clinicaspuc.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.clinicaspuc.model.Agenda;
import br.com.clinicaspuc.service.AgendaService;
import br.com.clinicaspuc.service.ConsultaService;

@Path("/agenda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendaApi {
	
	@EJB
	private AgendaService agendaService;
	
	@EJB
	private ConsultaService consultaService;
	
	@GET
	public Response getAll(){
		List<Agenda> agendas = null;
		try {
			agendas = agendaService.obterAgendas();
		} catch (Exception e) {
			throw e;
		}
		return Response.ok(agendas).build();
	}
	
	@GET
	@Path("{codigo}")
	public Response getPorCodigo(@PathParam("codigo") int codigo) {
		Agenda agenda = null;
		try {
			agenda = agendaService.obterPorId(codigo);
		} catch (Exception e) {
			throw e;
		}
		if(agenda !=null) {
			return Response.ok(agenda).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}	
	
	/*
	 * @GET
	 * 
	 * @Path("/usuario/{codUsuario}") public Response
	 * getPorCodigoUsuario(@PathParam("codUsuario") int codUsuario){ List<Agenda>
	 * agendas = null; try { agendas =
	 * agendaService.oberAgendaPorUsuario(codUsuario); } catch (Exception e) { throw
	 * e; } return Response.ok(agendas).build(); }
	 */
	
	@POST
	public Response salvar(Agenda agenda) {
		Agenda a = null;
		try {
			a = agendaService.salvar(agenda);
		} catch (Exception e) {
			throw e;
		}
		return Response.ok(a).build();
	}
	
	@PUT
	@Path("{codigo}")
	public Response atualizar(@PathParam("codigo") int codigo,Agenda agenda) {
		Agenda a = null;
		try {
			a = agendaService.obterPorId(codigo);
			if (a != null) {
				a = agendaService.salvar(agenda);
			}
		} catch (Exception e) {
			throw e;
		}
		if(a !=null) {
			return Response.ok(a).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("/{codigo}")
	public Response excluir(@PathParam("codigo") Integer codigo) {
		Agenda m = agendaService.obterPorId(codigo);
		if (m != null) {
			agendaService.delete(m);
			return Response.ok().build();
		}else {
			//TODO Verificar status adequado
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
}
