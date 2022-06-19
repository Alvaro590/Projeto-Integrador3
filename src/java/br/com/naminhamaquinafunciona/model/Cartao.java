/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;




/**
 *
 * @author Usuário
 */
public class Cartao {

    private int id;
    private int numero;
    private String nome;     
    private String bandeira;
    private double limite;
    private int agencia;
    private int userId;
    private int numeroConta;

    public Cartao() {

    }

    public Cartao(int numero, String nome, String bandeira, double limite, int agencia, int userId, int numeroConta) {
        this.numero = numero;
        this.nome = nome;
        this.bandeira = bandeira;
        this.limite = limite;
        this.agencia = agencia;
        this.userId = userId;
        this.numeroConta = numeroConta;
    }

    public Cartao(int id, int numero, String nome, String bandeira, double limite, int agencia, int userId, int numeroConta) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.bandeira = bandeira;
        this.limite = limite;
        this.agencia = agencia;
        this.userId = userId;
        this.numeroConta = numeroConta;
    }

    
       
    
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    

}
