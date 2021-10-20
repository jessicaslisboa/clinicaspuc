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

import br.com.clinicaspuc.model.Consulta;

@Path("/consulta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaApi {
	
	@GET
	@Path("{codPaciente}")
	public List<Consulta> getConsultaPaciente( @QueryParam("codPaciente") int codPaciente){
		return null;
	} 
	
	
	@POST
	public Consulta salvar(Consulta consulta) {
		return consulta;
	}
	
	@PUT
	public void atualizar(Consulta consulta) {
		
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		
	}
	
}
