package com.mirror.alogeda.commons.model.viewmodel;

import com.mirror.alogeda.commons.model.Funcionarios;

public class CalculoFuncionario {
    private int id;
    private String nome;
    private String cpf;

    public CalculoFuncionario(Funcionarios fun) {
        id = fun.getId();
        nome = fun.getPessoas().getNome();
        cpf = fun.getPessoas().getCpf();
    }

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

}
