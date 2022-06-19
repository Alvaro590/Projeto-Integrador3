/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;

/**
 *
 * @author Usuário
 */
public class Despesa extends Lancamentos {

    private int numCartao;

    public Despesa(int id, String descricao, double valor, java.sql.Date data, int numConta, int numCartao) {
        super(id, descricao, valor, data, numConta);
        this.numCartao = numCartao;
    }

    public Despesa(String descricao, double valor, java.sql.Date data, int numConta) {
        super(descricao, valor, data, numConta);
    }

    public Despesa(int id, String descricao, double valor, java.sql.Date data, int numConta) {
        super(id, descricao, valor, data, numConta);
    }

    public Despesa(String descricao, double valor, java.sql.Date data, int numConta, int numCartao) {
        super(descricao, valor, data, numConta);
        this.numCartao = numCartao;
    }

    public Despesa() {
    }

    public int getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    @Override
    public void corrigeValor() {
        this.setValor(this.getValor() * (-1));
    }

}
