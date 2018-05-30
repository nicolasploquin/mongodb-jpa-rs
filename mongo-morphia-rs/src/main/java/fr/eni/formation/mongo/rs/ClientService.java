package fr.eni.formation.mongo.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.eni.formation.mongo.banque.Client;
import fr.eni.formation.mongo.dao.ClientDAO;

@Path("/clients")
public class ClientService {
	
	@Inject
	ClientDAO dao;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String testClients() {
		return String.format("%d clients...", dao.readAll().size());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClients() {
		return dao.readAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postClient(Client client) {
		dao.create(client);
	}
	
	
}
