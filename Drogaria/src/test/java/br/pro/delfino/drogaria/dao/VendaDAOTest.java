package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		
		if (cliente != null && funcionario != null) {
			
			Venda venda = new Venda();
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			venda.setHorario(new Date(System.currentTimeMillis()));
			venda.setPrecoTotal(new BigDecimal(200));		
			
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda);
			
			System.out.println("Venda cadastrada com sucesso");		
			
		} else {
			System.out.println("Registros não encontrados!");
		}
		
	}
	
}
