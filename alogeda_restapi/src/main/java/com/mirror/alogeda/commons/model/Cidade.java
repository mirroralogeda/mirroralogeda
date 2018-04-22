package com.mirror.alogeda.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cidades", schema="mydb")
@SequenceGenerator(name = "cidades_seq", sequenceName = "cidades_seq", allocationSize = 1)
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidades_seq")
	private int id;
	private String nome;
	private String uf;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

}
