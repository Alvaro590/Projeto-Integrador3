/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;

import java.sql.Date;



/**
 *
 * @author Usuário
 */
public abstract class Lancamentos{
    
    private int id;
    private String descricao;
    private double valor;
    private Date data;    
    private int numConta;   
    
    public abstract void corrigeValor();

    public Lancamentos(int id, String descricao, double valor, Date data, int numConta) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.numConta = numConta;
    }

    public Lancamentos(String descricao, double valor, Date data, int numConta) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.numConta = numConta;
    }
    
    
    
    public Lancamentos(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    
    
    
}
