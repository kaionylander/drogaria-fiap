package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(1L);
		
		if(estado != null){
			Cidade cidade = new Cidade();
			cidade.setNome("São Caetano do Sul");
			cidade.setEstado(estado);
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
		} else {
			System.out.println("Estado não encontrado!");
		}	
		
	}
	
	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade != null){
			
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
		} else {
			System.out.println("Cidade não encontrada!");
		}		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade != null){
			
			cidadeDAO.excluir(cidade);
			
			System.out.println("Cidade Removida");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
		} else {
			System.out.println("Cidade não encontrada!");
		}
		
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoCidade = 2L;
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
						
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if(cidade != null && estado != null){
			
			System.out.println("Cidade A Ser Editada");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
			cidade.setNome("São Caetano do Sul");
			cidade.setEstado(estado);
			
			cidadeDAO.editar(cidade);
			
			System.out.println("Cidade Editada");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
		} else {			
			System.out.println("Registro não encontrado!");			
		}		
	}
	
	@Test
	@Ignore
	public void buscarPorEstado() {
		Long estadoCodigo = 7L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);

		for (Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
}
