package com.mirror.alogeda.commons.model;
// Generated 12/05/2018 21:02:31 by Hibernate Tools 4.3.1


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EveFixos generated by hbm2java
 */
@Entity
@Table(name="eve_fixos"
    ,schema="public"
)
@SequenceGenerator(name = "evefixos_seq", sequenceName = "evefixos_seq", allocationSize = 1)
public class EveFixos  implements java.io.Serializable {


     private int id;
     private Eventos eventos;
     private Funcionarios funcionarios;
     private Double valor;
     private String referencia;
     private Date perInicial;
     private Date perFinal;
     private Integer quantidadePeriodos;

    public EveFixos() {
    }

	
    public EveFixos(int id, Eventos eventos, Funcionarios funcionarios) {
        this.id = id;
        this.eventos = eventos;
        this.funcionarios = funcionarios;
    }
    public EveFixos(int id, Eventos eventos, Funcionarios funcionarios, Double valor, String referencia, Date perInicial, Date perFinal, Integer quantidadePeriodos) {
       this.id = id;
       this.eventos = eventos;
       this.funcionarios = funcionarios;
       this.valor = valor;
       this.referencia = referencia;
       this.perInicial = perInicial;
       this.perFinal = perFinal;
       this.quantidadePeriodos = quantidadePeriodos;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evefixos_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="eventos_id", nullable=false)
    public Eventos getEventos() {
        return this.eventos;
    }
    
    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="funcionarios_id", nullable=false)
    public Funcionarios getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    
    @Column(name="valor", precision=17, scale=17)
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    @Column(name="referencia", length=45)
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="per_inicial", length=13)
    public Date getPerInicial() {
        return this.perInicial;
    }
    
    public void setPerInicial(Date perInicial) {
        this.perInicial = perInicial;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="per_final", length=13)
    public Date getPerFinal() {
        return this.perFinal;
    }
    
    public void setPerFinal(Date perFinal) {
        this.perFinal = perFinal;
    }

    
    @Column(name="quantidade_periodos")
    public Integer getQuantidadePeriodos() {
        return this.quantidadePeriodos;
    }
    
    public void setQuantidadePeriodos(Integer quantidadePeriodos) {
        this.quantidadePeriodos = quantidadePeriodos;
    }




}

