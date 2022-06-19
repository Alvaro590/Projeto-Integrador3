/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;



/**
 *
 * @author Usuário
 */
public class ValidaBanco {

    

    public boolean bancoPermitido(String descricao) {
           
           
        return descricao.matches("^[a-zA-Z0-9_ ]*$")&&descricao.length()>3;
    }
    
    

}
