package com.mirror.alogeda.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cbo")
@SequenceGenerator(name = "cbo_seq", sequenceName = "cbo_seq", allocationSize = 1)
public class Cbo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cbo_seq")
	private int id;
	private int cbo;
	private String descricao;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCbo() {
		return cbo;
	}
	public void setCbo(int cbo) {
		this.cbo = cbo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
