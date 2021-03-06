package com.mirror.alogeda.commons.model;
// Generated 12/05/2018 21:02:31 by Hibernate Tools 4.3.1


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Enderecos generated by hbm2java
 */
@Entity
@Table(name="enderecos"
    ,schema="public"
)
@SequenceGenerator(name = "enderecos_seq", sequenceName = "enderecos_seq", allocationSize = 1)
public class Enderecos  implements java.io.Serializable {


     private int id;
     private Cidades cidades;
     private String bairro;
     private String rua;
     private Integer numero;
     private String complemento;
     private String cep;
     private Set<Pessoas> pessoases = new HashSet<Pessoas>(0);

    public Enderecos() {
    }

	
    public Enderecos(int id, Cidades cidades) {
        this.id = id;
        this.cidades = cidades;
    }
    public Enderecos(int id, Cidades cidades, String bairro, String rua, Integer numero, String complemento, String cep, Set<Pessoas> pessoases) {
       this.id = id;
       this.cidades = cidades;
       this.bairro = bairro;
       this.rua = rua;
       this.numero = numero;
       this.complemento = complemento;
       this.cep = cep;
       this.pessoases = pessoases;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecos_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cidades_id", nullable=false)
    public Cidades getCidades() {
        return this.cidades;
    }
    
    public void setCidades(Cidades cidades) {
        this.cidades = cidades;
    }

    
    @Column(name="bairro", length=200)
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    @Column(name="rua", length=200)
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    
    @Column(name="numero")
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    @Column(name="complemento", length=500)
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
    @Column(name="cep", length=8)
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="enderecos")
    public Set<Pessoas> getPessoases() {
        return this.pessoases;
    }
    
    public void setPessoases(Set<Pessoas> pessoases) {
        this.pessoases = pessoases;
    }




}


