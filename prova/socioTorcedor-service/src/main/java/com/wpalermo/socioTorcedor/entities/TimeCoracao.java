package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class TimeCoracao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idTimeCoracao;
	
	@Column
	private String nomeTimeCoracao;
	
	//@OneToMany(mappedBy = "timeCoracao", cascade = CascadeType.ALL)
	@Transient
	private List<Campanha> campanhasAssociadas;
	
	@OneToOne
	private SocioTorcedor socioTorcedor;
	
	
	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}
	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	public String getNomeTimeCoracao() {
		return nomeTimeCoracao;
	}
	public void setNomeTimeCoracao(String nomeTimeCoracao) {
		this.nomeTimeCoracao = nomeTimeCoracao;
	}
	public List<Campanha> getCampanhasAssociadas() {
		return campanhasAssociadas;
	}
	public void setCampanhasAssociadas(List<Campanha> campanhasAssociadas) {
		this.campanhasAssociadas = campanhasAssociadas;
	}
	public SocioTorcedor getSocioTorcedor() {
		return socioTorcedor;
	}
	public void setSocioTorcedor(SocioTorcedor socioTorcedor) {
		this.socioTorcedor = socioTorcedor;
	}
	
	
	
}
