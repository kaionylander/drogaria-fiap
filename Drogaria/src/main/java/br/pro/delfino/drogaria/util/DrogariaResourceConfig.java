package br.pro.delfino.drogaria.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//Pode ser qualquer nome, utilizaremos rest para o path: http://localhost:7070/Drogaria/rest
@ApplicationPath("rest")
public class DrogariaResourceConfig extends ResourceConfig {
	
	public DrogariaResourceConfig() {
		packages("br.pro.delfino.drogaria.service");
	}
	
}
