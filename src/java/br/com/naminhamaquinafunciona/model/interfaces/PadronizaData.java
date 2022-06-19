/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.naminhamaquinafunciona.model.interfaces;



/**
 *
 * @author Usuário
 */
public interface PadronizaData {
    
    public java.sql.Date StringToSql(String data);
    public java.sql.Date utilToSql(java.util.Date data);
    public java.util.Date toPrint(java.sql.Date data);
}
