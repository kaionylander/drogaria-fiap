package br.pro.delfino.drogaria.bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class ImagemBean {
	
	//Atribuindo parâmetro com o name="caminho" para variável String caminho
	@ManagedProperty("#{param.caminho}")
	private String caminho;
	
	//Atributo para salvar os bytes da foto
	//@RequestScoped será carregado a cada clique (requisição)
	private StreamedContent foto;
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	//Método utilizado para carregar imagem em branco quando caminho for nulo ou vazio, 
	//caso contrário, carrega por meio do caminho recebido por parâmetro
	public StreamedContent getFoto() throws IOException {
		if(caminho == null || caminho.isEmpty()){
			//Carregando foto branca de 1 pixel
			Path path = Paths.get("D:/workspace/Drogaria/uploads/branco.png");
			//Abrindo imagem e recebendo os bytes
			InputStream stream = Files.newInputStream(path);
			//Recendo o fluxo de bytes do stream para foto
			foto = new DefaultStreamedContent(stream);
		} else {
			//Carregando foto pelo caminho
			Path path = Paths.get(caminho);
			InputStream stream = Files.newInputStream(path);
			foto = new DefaultStreamedContent(stream);
		}
		return foto;
	}
	
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
}