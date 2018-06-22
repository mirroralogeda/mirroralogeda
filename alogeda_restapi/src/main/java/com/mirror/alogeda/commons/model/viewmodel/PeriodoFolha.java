package com.mirror.alogeda.commons.model.viewmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PeriodoFolha {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perInicial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date perFinal;
    private int calculos;
    private boolean fechado;

    public PeriodoFolha() {

    }

    public PeriodoFolha(Date perInicial, Date perFinal, int calculos, boolean fechado) {
        this.perInicial = perInicial;
        this.perFinal = perFinal;

        this.calculos = calculos;
        this.fechado = fechado;
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
     * @return the calculos
     */
    public int getCalculos() {
        return calculos;
    }

    /**
     * @param calculos the calculos to set
     */
    public void setCalculos(int calculos) {
        this.calculos = calculos;
    }

    /**
     * @return the fechado
     */
    public boolean isFechado() {
        return fechado;
    }

    /**
     * @param fechado the fechado to set
     */
    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

}
