/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;

/**
 *
 * @author Usuário
 */
public class Conta {

    private int id;
    private int numero;
    private double saldo;
    private double limite;
    private int userId;

    public Conta() {

    }

    public Conta(int numero, double saldo, double limite, int userId) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.userId = userId;
    }
    
    public Conta(int id, int numero, double saldo, double limite, int userId) {
        this.id=id;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.userId = userId;
    }

    public Conta( int numero, double saldo, double limite) {
       
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        
    }
    
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

}
