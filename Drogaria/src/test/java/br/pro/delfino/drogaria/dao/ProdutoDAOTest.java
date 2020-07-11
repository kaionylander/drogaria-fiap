package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));
		
		if(fabricante != null){
			
			Produto produto = new Produto();
			produto.setDescricao("Loratadina 10mg");
			produto.setFabricante(fabricante);
			produto.setPreco(new BigDecimal("13.69"));
			produto.setQuantidade(new Short("10"));
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			
			System.out.println("Produto salvo com sucesso");
			
		} else {
			System.out.println("Fabricante não encontrado");
		}		
		
	}
	
}
