package br.com.clinicaspuc.rs;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.clinicaspuc.rs.dto.UsuarioLogin;
import br.com.clinicaspuc.service.UsuarioService;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthApi {
	
	@EJB
	private UsuarioService usuarioService;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(UsuarioLogin usuario) {
		try {
			if (usuarioService.verificaLogin(usuario)) {
				return Response.status(Response.Status.OK).build();
			} else
				return Response.status(Response.Status.UNAUTHORIZED).entity("Usuário e/ou senha inválidos").build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	/*
	 * @POST public Response criarUsuario(Usuario usuario) { Usuario p = null; try {
	 * p = usuarioService.salvar(usuario); } catch (Exception e) { throw e; } return
	 * Response.ok(p).build(); }
	 */
}
