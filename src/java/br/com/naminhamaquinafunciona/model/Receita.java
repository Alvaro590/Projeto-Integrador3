/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;




/**
 *
 * @author Usuário
 */
public class Receita extends Lancamentos{

    public Receita(int id, String descricao, double valor, java.sql.Date data, int idConta) {
        super(id, descricao, valor, data, idConta);
    }

    public Receita(String descricao, double valor, java.sql.Date data, int idConta) {
        super(descricao, valor, data, idConta);
    }
       
    public Receita(){
        
    }  

    @Override
    public void corrigeValor() {
                
    }   
    
}
