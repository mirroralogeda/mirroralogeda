package com.mirror.alogeda.commons.model.viewmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PeriodoFolha {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perFinal;
    private String calculoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dataCalculo;

    public PeriodoFolha() {

    }

    public PeriodoFolha(Date perInicial, Date perFinal, Date dataCalculo, String id) {
        this.perInicial = perInicial;
        this.perFinal = perFinal;
        this.dataCalculo = dataCalculo;
        this.calculoId = id;
    }

    /**
     * @return the perInicial
     */
    public Date getPerInicial() {
        return perInicial;
    }

    /**
     * @param perInicial the perInicial to set
     */
    public void setPerInicial(Date perInicial) {
        this.perInicial = perInicial;
    }

    /**
     * @return the perFinal
     */
    public Date getPerFinal() {
        return perFinal;
    }

    /**
     * @param perFinal the perFinal to set
     */
    public void setPerFinal(Date perFinal) {
        this.perFinal = perFinal;
    }

    /**
     * @return the dataCalculo
     */
    public Date getDataCalculo() {
        return dataCalculo;
    }

    /**
     * @param dataCalculo the dataCalculo to set
     */
    public void setDataCalculo(Date dataCalculo) {
        this.dataCalculo = dataCalculo;
    }

    /**
     * @return the calculoId
     */
    public String getCalculoId() {
        return calculoId;
    }

    /**
     * @param calculoId the calculoId to set
     */
    public void setCalculoId(String calculoId) {
        this.calculoId = calculoId;
    }

}
