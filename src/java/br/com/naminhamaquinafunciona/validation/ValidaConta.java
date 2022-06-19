/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;

/**
 *
 * @author Usuário
 */
public class ValidaConta {
    
    public boolean contaPermitida(String numero){
        int aux= Integer.parseInt(numero);
        if(aux==0){
            return false;
        }  
        
        return numero.matches("\\d+")&&numero.length()>3;
        

        
    }
    
}
