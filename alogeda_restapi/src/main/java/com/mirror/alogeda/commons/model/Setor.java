package com.mirror.alogeda.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "setores")
@SequenceGenerator(name = "setores_seq", sequenceName = "setores_seq", allocationSize = 1)
public class Setor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setores_seq")
	private int id;
	private String nome;

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

}
