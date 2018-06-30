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

/**
 * Vagas generated by hbm2java
 */
@Entity
@Table(name="vagas"
    ,schema="public"
)
@SequenceGenerator(name = "vagas_seq", sequenceName = "vagas_seq", allocationSize = 1)
public class Vagas  implements java.io.Serializable {


     private int id;
     private Cargos cargos;
     private Date dataInicio;
     private Date dataFim;
     private Integer quantidade;
     private String descGeral;
     private Integer tipoLiberacao;
     private Set<Curriculos> curriculoses = new HashSet<Curriculos>(0);
     private Set<Habilidades> habilidadeses = new HashSet<Habilidades>(0);

    public Vagas() {
    }

	
    public Vagas(int id, Cargos cargos) {
        this.id = id;
        this.cargos = cargos;
    }
    public Vagas(int id, Cargos cargos, Date dataInicio, Date dataFim, Integer quantidade, String descGeral, Integer tipoLiberacao, Set<Curriculos> curriculoses, Set<Habilidades> habilidadeses) {
       this.id = id;
       this.cargos = cargos;
       this.dataInicio = dataInicio;
       this.dataFim = dataFim;
       this.quantidade = quantidade;
       this.descGeral = descGeral;
       this.tipoLiberacao = tipoLiberacao;
       this.curriculoses = curriculoses;
       this.habilidadeses = habilidadeses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vagas_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cargos_id", nullable=false)
    public Cargos getCargos() {
        return this.cargos;
    }
    
    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_inicio", length=22)
    public Date getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_fim", length=22)
    public Date getDataFim() {
        return this.dataFim;
    }
    
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    
    @Column(name="quantidade")
    public Integer getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    
    @Column(name="desc_geral", length=1000)
    public String getDescGeral() {
        return this.descGeral;
    }
    
    public void setDescGeral(String descGeral) {
        this.descGeral = descGeral;
    }

    
    @Column(name="tipo_liberacao")
    public Integer getTipoLiberacao() {
        return this.tipoLiberacao;
    }
    
    public void setTipoLiberacao(Integer tipoLiberacao) {
        this.tipoLiberacao = tipoLiberacao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vagas")
    public Set<Curriculos> getCurriculoses() {
        return this.curriculoses;
    }
    
    public void setCurriculoses(Set<Curriculos> curriculoses) {
        this.curriculoses = curriculoses;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="habilidades_vagas", schema="public", joinColumns = { 
        @JoinColumn(name="vagas_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="habilidades_id", nullable=false, updatable=false) })
    public Set<Habilidades> getHabilidadeses() {
        return this.habilidadeses;
    }
    
    public void setHabilidadeses(Set<Habilidades> habilidadeses) {
        this.habilidadeses = habilidadeses;
    }




}


