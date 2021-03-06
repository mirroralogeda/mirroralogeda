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
 * Salarios generated by hbm2java
 */
@Entity
@Table(name="salarios"
    ,schema="public"
)
@SequenceGenerator(name = "salarios_seq", sequenceName = "salarios_seq", allocationSize = 1)
public class Salarios  implements java.io.Serializable {


     private int id;
     private Funcionarios funcionarios;
     private Double valor;
     private Date vigInicial;
     private Date vigFinal;
     private String observacao;

    public Salarios() {
    }

	
    public Salarios(int id, Funcionarios funcionarios) {
        this.id = id;
        this.funcionarios = funcionarios;
    }
    public Salarios(int id, Funcionarios funcionarios, Double valor, Date vigInicial, Date vigFinal, String observacao) {
       this.id = id;
       this.funcionarios = funcionarios;
       this.valor = valor;
       this.vigInicial = vigInicial;
       this.vigFinal = vigFinal;
       this.observacao = observacao;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarios_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="vig_inicial", length=22)
    public Date getVigInicial() {
        return this.vigInicial;
    }
    
    public void setVigInicial(Date vigInicial) {
        this.vigInicial = vigInicial;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="vig_final", length=22)
    public Date getVigFinal() {
        return this.vigFinal;
    }
    
    public void setVigFinal(Date vigFinal) {
        this.vigFinal = vigFinal;
    }

    
    @Column(name="observacao", length=1000)
    public String getObservacao() {
        return this.observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }




}


