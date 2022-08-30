/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Miriam
 */
public class Paciente {
    private int idpaciente;
    private String nome;
    private String cpf;
    private String email;
    private String sexo;
    private String telefone;
    private String datanasc;

    public Paciente(int idpaciente, String nome, String cpf, String email, String sexo, String telefone, String datanasc) {
        this.idpaciente = idpaciente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.datanasc = datanasc;
    }

    public Paciente() {
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }
    
    
}
