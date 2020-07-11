package br.pro.delfino.drogaria.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3L);
		
		if(pessoa != null) {
			
			Usuario usuario = new Usuario();
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenhaSemCriptografia("abc123");
			
			//Classe do Apache Shiro para criptografar, passa o objeto sem criptografia.
			SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
			//Executando a criptogafia
			usuario.setSenha(hash.toHex());
						
			usuario.setTipo('B');
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			
			System.out.println("Usuário cadastrado com sucesso");
			
		} else {
			System.out.println("Pessoa não encontrada");
		}
	}
	
	@Test
	@Ignore
	public void autenticar(){
		String cpf = "111.111.111-11";
		String senha = "abc123";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.autenticar(cpf, senha);
		
		System.out.println("Usuário autentica: " + usuario);
	}
	
}
