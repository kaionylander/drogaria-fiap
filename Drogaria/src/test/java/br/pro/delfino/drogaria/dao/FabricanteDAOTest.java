package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Pfizer");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	public void listar() {
		FabricanteDAO FabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = FabricanteDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
			
			fabricante.setDescricao("EMS");
			fabricanteDAO.editar(fabricante);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void merge() {
		/*Testando merge para inclusão
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Pfizer");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);*/
		
		/*Testando merge para edição
		FabricanteDAO fabricanteDAO = new FabricanteDAO();		
		Fabricante fabricante = fabricanteDAO.buscar(1L);
		fabricante.setDescricao("Roché");
		fabricanteDAO.merge(fabricante);*/
	}
	
}