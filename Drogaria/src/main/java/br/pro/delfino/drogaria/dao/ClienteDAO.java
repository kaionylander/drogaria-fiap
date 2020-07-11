package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.util.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			
			Criteria consulta = sessao.createCriteria(Cliente.class);
			consulta.createAlias("pessoa", "p");
			consulta.addOrder(Order.asc("p.nome"));
			List<Cliente> resultado = consulta.list();
			
			//Validando se o cliente está ativo no banco
			for (Cliente cliente : resultado) {
				if(cliente.getLiberado() != true) {					
					resultado.remove(cliente);
				}					
			}
			
			return resultado;
			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}
