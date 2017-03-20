/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p17032017;

/**
 *
 * @author Missy M
 */
public class Pessoa {
    
    private String nome;
    private String email;
    private String morada;
    private int tlm;

    public Pessoa(String nome, String email, String morada, int tlm) {
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.tlm = tlm;
    }

    public int getTlm() {
        return tlm;
    }

    public void setTlm(int tlm) {
        this.tlm = tlm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
}
