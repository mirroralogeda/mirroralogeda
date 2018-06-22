package com.mirror.alogeda.commons.model.viewmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalculoAcessor {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dataCalculo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perFinal;

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
    public java.util.Date getPerFinal() {
        return perFinal;
    }

    /**
     * @param perFinal the perFinal to set
     */
    public void setPerFinal(java.util.Date perFinal) {
        this.perFinal = perFinal;
    }

}
