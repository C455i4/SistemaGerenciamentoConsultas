/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Miriam
 */
public class Medico {
    private int idmedico;
    private String nome;
    private String crm;
    private String email;
    private String telefone;
    private String especializacao;

    public Medico() {
    }

    public Medico(int idmedico, String nome, String crm, String email, String telefone, String especializacao) {
        this.idmedico = idmedico;
        this.nome = nome;
        this.crm = crm;
        this.email = email;
        this.telefone = telefone;
        this.especializacao = especializacao;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    
}
