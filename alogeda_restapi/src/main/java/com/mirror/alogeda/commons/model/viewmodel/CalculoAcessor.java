package com.mirror.alogeda.commons.model.viewmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalculoAcessor {
    private String calculoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date dataCalculo;

    /**
     * @return the dataCalculo
     */
    public Date getDataCalculo() {
        return dataCalculo;
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
