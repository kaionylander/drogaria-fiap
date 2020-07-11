package br.pro.delfino.drogaria.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//Classe repositório de serviços
//http://localhost:7070/Drogaria/rest/drogaria
@Path("drogaria")
public class DrogariaService {
	
	//Criando o primeiro serviço
	@GET
	public String exibir() {
		return "Primeiro Serviço!";
	}
	
}
