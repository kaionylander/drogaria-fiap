package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe responsável por moldar os fabricantes do Banco
 *
 * @author Kaio Nylander
 */

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}