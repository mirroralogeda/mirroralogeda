package com.mirror.alogeda.commons.model;
// Generated 12/05/2018 21:02:31 by Hibernate Tools 4.3.1


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Curriculos generated by hbm2java
 */
@Entity
@Table(name="curriculos"
    ,schema="public"
)
@SequenceGenerator(name = "curriculos_seq", sequenceName = "curriculos_seq", allocationSize = 1)
public class Curriculos  implements java.io.Serializable {


     private int id;
     private Pessoas pessoas;
     private Vagas vagas;
     private Date dataModificacao;
     private String descricao;
     private Short aprovadoSelecao;
     private String motivo;
     private String pdf;
     private Short aprovadoEntrevista;
     private Set<Formacoes> formacoeses = new HashSet<Formacoes>(0);
     private Set<Experiencias> experienciases = new HashSet<Experiencias>(0);
     private Set<Habilidades> habilidadeses = new HashSet<Habilidades>(0);

    public Curriculos() {
    }

	
    public Curriculos(int id, Pessoas pessoas) {
        this.id = id;
        this.pessoas = pessoas;

    }
    public Curriculos(int id, Pessoas pessoas, Vagas vagas, Date dataModificacao, String descricao, Short aprovadoSelecao, String motivo, String pdf, Short aprovadoEntrevista, Set<Formacoes> formacoeses, Set<Experiencias> experienciases, Set<Habilidades> habilidadeses) {
       this.id = id;
       this.pessoas = pessoas;
       this.vagas = vagas;
       this.dataModificacao = dataModificacao;
       this.descricao = descricao;
       this.aprovadoSelecao = aprovadoSelecao;
       this.motivo = motivo;
       this.pdf = pdf;
       this.aprovadoEntrevista = aprovadoEntrevista;
       this.formacoeses = formacoeses;
       this.experienciases = experienciases;
       this.habilidadeses = habilidadeses;
    }
   
    @Id 
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curriculos_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pessoas_id", nullable=false)
    public Pessoas getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vagas_id", nullable=false)
    public Vagas getVagas() {
        return this.vagas;
    }
    
    public void setVagas(Vagas vagas) {
        this.vagas = vagas;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_modificacao", length=22)
    public Date getDataModificacao() {
        return this.dataModificacao;
    }
    
    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    @Column(name="descricao", length=5000)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="aprovado_selecao")
    public Short getAprovadoSelecao() {
        return this.aprovadoSelecao;
    }
    
    public void setAprovadoSelecao(Short aprovadoSelecao) {
        this.aprovadoSelecao = aprovadoSelecao;
    }

    
    @Column(name="motivo", length=500)
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
    @Column(name="pdf")
    public String getPdf() {
        return this.pdf;
    }
    
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    
    @Column(name="aprovado_entrevista")
    public Short getAprovadoEntrevista() {
        return this.aprovadoEntrevista;
    }
    
    public void setAprovadoEntrevista(Short aprovadoEntrevista) {
        this.aprovadoEntrevista = aprovadoEntrevista;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="curriculos")
    public Set<Formacoes> getFormacoeses() {
        return this.formacoeses;
    }
    
    public void setFormacoeses(Set<Formacoes> formacoeses) {
        this.formacoeses = formacoeses;
    }
 
    @OneToMany(fetch=FetchType.LAZY, mappedBy="curriculos")
    public Set<Experiencias> getExperienciases() {
        return this.experienciases;
    }
    
    public void setExperienciases(Set<Experiencias> experienciases) {
        this.experienciases = experienciases;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="habilidades_curriculos", schema="public", joinColumns = { 
    @JoinColumn(name="curriculos_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
    @JoinColumn(name="habilidades_id", nullable=false, updatable=false) })
    public Set<Habilidades> getHabilidadeses() {
        return this.habilidadeses;
    }
    
    public void setHabilidadeses(Set<Habilidades> habilidadeses) {
        this.habilidadeses = habilidadeses;
    }




}


