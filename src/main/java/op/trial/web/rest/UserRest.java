package op.trial.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import op.trial.domain.User;
import op.trial.service.UserService;


@Component
@Path("/user")
public class UserRest {
	@Autowired
	private UserService userService;
 
	@POST 
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(User user) { 
		userService.save(user);
		return Response.status(200).entity("User upadted").build();
	} 
	
	@GET 
	@Path("/error")
	@Produces("application/pdf")
	public Response error() {		
		return Response.status(500).entity("Internat server error. Example.").header("Content-Type", MediaType.TEXT_HTML).build();
	} 
}
