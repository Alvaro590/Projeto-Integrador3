/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.Despesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class DespesaRemover extends DespesaAbstract {

    private Connection connection = Conexao.getConnection();

    @Override
    public void executarMetodo(Despesa despesa) {

        try {
            String sql = "DELETE FROM despesa WHERE id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, despesa.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
