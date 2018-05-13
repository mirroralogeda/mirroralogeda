package com.mirror.alogeda.commons.model;
// Generated 12/05/2018 21:02:31 by Hibernate Tools 4.3.1


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pessoas generated by hbm2java
 */
@Entity
@Table(name="pessoas"
    ,schema="public"
)
@SequenceGenerator(name = "pessoas_seq", sequenceName = "pessoas_seq", allocationSize = 1)
public class Pessoas  implements java.io.Serializable {


     private int id;
     private Enderecos enderecos;
     private EstCivil estCivil;
     private String nome;
     private String cpf;
     private String rg;
     private String orgaoEmissorRg;
     private String estadoEmissorRg;
     private String dataEmissãoRg;
     private String email;
     private String telefone;
     private Integer genero;
     private Date dataNascimento;
     private Set<Curriculos> curriculoses = new HashSet<Curriculos>(0);
     private Set<Funcionarios> funcionarioses = new HashSet<Funcionarios>(0);

    public Pessoas() {
    }

	
    public Pessoas(int id, Enderecos enderecos, EstCivil estCivil) {
        this.id = id;
        this.enderecos = enderecos;
        this.estCivil = estCivil;
    }
    public Pessoas(int id, Enderecos enderecos, EstCivil estCivil, String nome, String cpf, String rg, String orgaoEmissorRg, String estadoEmissorRg, String dataEmissãoRg, String email, String telefone, Integer genero, Date dataNascimento, Set<Curriculos> curriculoses, Set<Funcionarios> funcionarioses) {
       this.id = id;
       this.enderecos = enderecos;
       this.estCivil = estCivil;
       this.nome = nome;
       this.cpf = cpf;
       this.rg = rg;
       this.orgaoEmissorRg = orgaoEmissorRg;
       this.estadoEmissorRg = estadoEmissorRg;
       this.dataEmissãoRg = dataEmissãoRg;
       this.email = email;
       this.telefone = telefone;
       this.genero = genero;
       this.dataNascimento = dataNascimento;
       this.curriculoses = curriculoses;
       this.funcionarioses = funcionarioses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoas_seq")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="enderecos_id", nullable=false)
    public Enderecos getEnderecos() {
        return this.enderecos;
    }
    
    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="est_civil_id", nullable=false)
    public EstCivil getEstCivil() {
        return this.estCivil;
    }
    
    public void setEstCivil(EstCivil estCivil) {
        this.estCivil = estCivil;
    }

    
    @Column(name="nome", length=200)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="cpf", length=11)
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    @Column(name="rg", length=45)
    public String getRg() {
        return this.rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }

    
    @Column(name="orgao_emissor_rg", length=45)
    public String getOrgaoEmissorRg() {
        return this.orgaoEmissorRg;
    }
    
    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    
    @Column(name="estado_emissor_rg", length=45)
    public String getEstadoEmissorRg() {
        return this.estadoEmissorRg;
    }
    
    public void setEstadoEmissorRg(String estadoEmissorRg) {
        this.estadoEmissorRg = estadoEmissorRg;
    }

    
    @Column(name="data_emissão_rg", length=45)
    public String getDataEmissãoRg() {
        return this.dataEmissãoRg;
    }
    
    public void setDataEmissãoRg(String dataEmissãoRg) {
        this.dataEmissãoRg = dataEmissãoRg;
    }

    
    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="telefone", length=20)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    @Column(name="genero")
    public Integer getGenero() {
        return this.genero;
    }
    
    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_nascimento", length=22)
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pessoas")
    public Set<Curriculos> getCurriculoses() {
        return this.curriculoses;
    }
    
    public void setCurriculoses(Set<Curriculos> curriculoses) {
        this.curriculoses = curriculoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pessoas")
    public Set<Funcionarios> getFuncionarioses() {
        return this.funcionarioses;
    }
    
    public void setFuncionarioses(Set<Funcionarios> funcionarioses) {
        this.funcionarioses = funcionarioses;
    }




}


