package com.mirror.alogeda.commons.model.viewmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalculoPeriodo {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dataCalculo;
    private int funcionarios;
    private boolean fechamento;

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
     * @return the funcionarios
     */
    public int getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * @return the fechamento
     */
    public boolean isFechamento() {
        return fechamento;
    }

    /**
     * @param fechamento the fechamento to set
     */
    public void setFechamento(boolean fechamento) {
        this.fechamento = fechamento;
    }

}
