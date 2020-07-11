package br.pro.delfino.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setBairro("Parque das Nações");
		pessoa.setCelular("(99)99999-1530");
		pessoa.setCep("09210-99");
		pessoa.setCpf("979.999.999-77");
		pessoa.setEmail("ciclano@gmail.com");
		pessoa.setNome("Ciclano da Silva");
		pessoa.setNumero((short) 583);
		pessoa.setRg("97.999.999-7");
		pessoa.setRua("Rua Alemanha");
		pessoa.setTelefone("(11)4352-1212");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
	}
	
}
