package com.wpalermo.socioTorcedor.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class SocioTorcedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	
	@Column
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="socioTorcedor")
	private TimeCoracao timeCoracao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}
	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}
	
	
	
	
}