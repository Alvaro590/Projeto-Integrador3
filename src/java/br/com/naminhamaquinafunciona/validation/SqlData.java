/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;

import br.com.naminhamaquinafunciona.model.interfaces.PadronizaData;
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
public class SqlData implements PadronizaData {

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date StringToSql(String data) {
        java.sql.Date dataSql = null;
        try {
            dataSql = new java.sql.Date(format.parse(data).getTime());

        } catch (ParseException ex) {
            Logger.getLogger(SqlData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSql;
    }

    @Override
    public Date utilToSql(java.util.Date data) {
        java.sql.Date sqlDate = new java.sql.Date(data.getTime());
        return sqlDate;
    }

    @Override
    public Date toPrint(Date data) {
        Date aux = StringToSql(format2.format(data));
        return aux;
    }

}
