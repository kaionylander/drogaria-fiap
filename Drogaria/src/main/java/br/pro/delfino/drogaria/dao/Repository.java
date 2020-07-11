package br.pro.delfino.drogaria.dao;

import java.util.List;

public interface Repository<Entidade> {
	
	public void salvar(Entidade entidade);
	
	public List<Entidade> listar();
	
	public Entidade buscar(Long codigo);
	
	public void excluir(Entidade entidade);
	
	public void editar(Entidade entidade);
	
}
