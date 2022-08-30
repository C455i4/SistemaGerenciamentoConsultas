/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Miriam
 */
public class Funcionario {
    private int idfunc;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String dataadmissao;
    private String sexo;

    public Funcionario(int idfunc, String nome, String cpf, String email, String telefone, String dataadmissao, String sexo) {
        this.idfunc = idfunc;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataadmissao = dataadmissao;
        this.sexo = sexo;
    }

    public Funcionario() {
    }

    public int getIdfunc() {
        return idfunc;
    }

    public void setIdfunc(int idfunc) {
        this.idfunc = idfunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(String dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
