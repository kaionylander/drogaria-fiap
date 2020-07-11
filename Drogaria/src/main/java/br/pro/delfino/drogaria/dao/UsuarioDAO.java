package br.pro.delfino.drogaria.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pro.delfino.drogaria.domain.Usuario;
import br.pro.delfino.drogaria.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {
	
	/**
	 * Método valida se cpf e senha informados estão contidos no banco
	 * @param cpf campo cpf da classe Pessoa
	 * @param senha campo cpf da classe Usuario
	 * @return Usuario o usuario contido no banco
	 */
	public Usuario autenticar(String cpf, String senha) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.createAlias("pessoa", "p");
			
			consulta.add(Restrictions.eq("p.cpf", cpf));
			
			//SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("senha", senha));
			
			Usuario resultado = (Usuario) consulta.uniqueResult();
			
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}