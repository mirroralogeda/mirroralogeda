package com.mirror.alogeda.commons.model.viewmodel;

import java.math.BigDecimal;
import java.util.List;

public class FolhaFuncionario {
    private int id;
    private String nome;
    private String cpf;
    private List<ItemFolha> itens;
    private BigDecimal totalProventos;
    private BigDecimal totalDescontos;
    private BigDecimal totalNeutros;
    private BigDecimal salarioLiquido;
    private BigDecimal salarioBruto;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the itens
     */
    public List<ItemFolha> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<ItemFolha> itens) {
        this.itens = itens;
    }

    /**
     * @return the totalProventos
     */
    public BigDecimal getTotalProventos() {
        return totalProventos;
    }

    /**
     * @param totalProventos the totalProventos to set
     */
    public void setTotalProventos(BigDecimal totalProventos) {
        this.totalProventos = totalProventos;
    }

    /**
     * @return the totalDescontos
     */
    public BigDecimal getTotalDescontos() {
        return totalDescontos;
    }

    /**
     * @param totalDescontos the totalDescontos to set
     */
    public void setTotalDescontos(BigDecimal totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    /**
     * @return the salarioBruto
     */
    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    /**
     * @param salarioBruto the salarioBruto to set
     */
    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    /**
     * @return the salarioLiquido
     */
    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    /**
     * @param salarioLiquido the salarioLiquido to set
     */
    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    /**
     * @return the totalNeutros
     */
    public BigDecimal getTotalNeutros() {
        return totalNeutros;
    }

    /**
     * @param totalNeutros the totalNeutros to set
     */
    public void setTotalNeutros(BigDecimal totalNeutros) {
        this.totalNeutros = totalNeutros;
    }
}
