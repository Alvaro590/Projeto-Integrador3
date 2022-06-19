/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;

import br.com.naminhamaquinafunciona.controller.Controller;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class ValidaReceita {
    
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public Date PadronizaData(String dataString) {        
        java.sql.Date datasql = null;
        try {
            datasql = new java.sql.Date(format.parse(dataString).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datasql;
    }

}
