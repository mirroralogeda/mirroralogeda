package com.mirror.alogeda.commons.model;
// Generated 12/05/2018 21:02:31 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ParametrosFolha generated by hbm2java
 */
@Entity
@Table(name = "parametros_folha", schema = "public")
@SequenceGenerator(name = "parametrosfolha_seq", sequenceName = "parametrosfolha_seq", allocationSize = 1)
public class ParametrosFolha implements java.io.Serializable {

    private int id;
    private Date perInicial;
    private Date perFinal;

    public ParametrosFolha() {
    }

    public ParametrosFolha(int id) {
        this.id = id;
    }

    public ParametrosFolha(int id, Date perInicial, Date perFinal) {
        this.id = id;
        this.perInicial = perInicial;
        this.perFinal = perFinal;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parametrosfolha_seq")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "per_inicial", length = 22)
    public Date getPerInicial() {
        return this.perInicial;
    }

    public void setPerInicial(Date perInicial) {
        this.perInicial = perInicial;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "per_final", length = 22)
    public Date getPerFinal() {
        return this.perFinal;
    }

    public void setPerFinal(Date perFinal) {
        this.perFinal = perFinal;
    }

}
