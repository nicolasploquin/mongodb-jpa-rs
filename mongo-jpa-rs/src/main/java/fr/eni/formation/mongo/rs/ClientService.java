package fr.eni.formation.mongo.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.eni.formation.mongo.banque.Client;
import fr.eni.formation.mongo.dao.ClientDAO;

@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
	public List<Client> getClients() {
		return dao.readAll();
	}
	
	@POST
	public void postClient(Client client) {
		dao.create(client);
	}
	
	@GET
	@Path("/nom/{nom}")
	public List<Client> getClientsNom(@PathParam("nom") String nom) {
		return dao.readNom(nom);
	}

	
}
