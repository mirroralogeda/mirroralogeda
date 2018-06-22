package com.mirror.alogeda.commons.model.viewmodel;

import java.math.BigDecimal;

import com.mirror.alogeda.commons.model.TipoEvento;

public class ItemFolha {
    private String nome;
    private String referencia;
    private BigDecimal valor;
    private TipoEvento tipo;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

}
