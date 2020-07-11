package br.pro.delfino.drogaria.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;

import br.pro.delfino.drogaria.dao.FabricanteDAO;
import br.pro.delfino.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = new Fabricante();
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	public void novo() {
		this.fabricante = new Fabricante();
	}
	
	@PostConstruct
	public void listar(){
		try{
			/*FabricanteDAO fabricanteDAO = new FabricanteDAO();
			this.fabricantes = fabricanteDAO.listar();*/
			
			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://127.0.0.1:7070/Drogaria/rest/fabricante");
			//Disparando uma requisição que retorna uma String (JSON)
			String json = caminho.request().get(String.class);
			
			//Convertendo String para ArrayList
			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			////Convertendo vetor para ArrayList
			fabricantes = Arrays.asList(vetor);
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fabricantes");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		
		try {
			
			/*Modelo antigo de persistência			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);
			
			novo();
			fabricantes = fabricanteDAO.listar();*/
			
			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://127.0.0.1:7070/Drogaria/rest/fabricante");
			
			//Convertendo Fabricante para String
			Gson gson = new Gson();
			String json = gson.toJson(fabricante);
			
			//Requisição de serviço via POST
			caminho.request().post(Entity.json(json));
			
			this.novo();
			
			//Chamando o listar via serviço novamente
			json = caminho.request().get(String.class);			
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			////Convertendo vetor para ArrayList
			fabricantes = Arrays.asList(vetor);
			
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
			
		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fabricante");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

			Client cliente = ClientBuilder.newClient();
			
			WebTarget caminho = cliente.target("http://127.0.0.1:7070/Drogaria/rest/fabricante");
			WebTarget caminhoExcluir = caminho.path("{codigo}").resolveTemplate("codigo", fabricante.getCodigo());
			
			caminhoExcluir.request().delete();
			String json = caminho.request().get(String.class);
			
			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			
			fabricantes = Arrays.asList(vetor);

			Messages.addGlobalInfo("Fabricante removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o fabricante");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:7070/Drogaria/rest/fabricante");
		
		//Convertendo Fabricante para String
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);
		
		//Requisição de serviço via PUT
		caminho.request().put(Entity.json(json));
		
		//Chamando o listar via serviço novamente
		json = caminho.request().get(String.class);			
		Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
		////Convertendo vetor para ArrayList
		fabricantes = Arrays.asList(vetor);
		
	}
	
}
