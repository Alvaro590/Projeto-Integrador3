/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;

/**
 *
 * @author Usuário
 */
public class ValidaCartao {
    
    public boolean validaNomeCartao(String nome){
        
        return nome.matches("^[a-zA-Z]+$");
    }
    public boolean validaAgenciaCartao(int agencia){
        String aux=agencia+"";
        return (aux.matches("\\d+"));
                
    }
}
