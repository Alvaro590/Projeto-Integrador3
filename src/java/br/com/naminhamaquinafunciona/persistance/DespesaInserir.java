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
public class DespesaInserir extends DespesaAbstract {

    private Connection connection = Conexao.getConnection();

    @Override
    public void executarMetodo(Despesa despesa) {

     
        try {
            String sql = "INSERT INTO despesa (id, descricao, valor, data_despesa, num_conta, num_cartao) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, despesa.getId());
            ps.setString(2, despesa.getDescricao());
            ps.setDouble(3, despesa.getValor());
            ps.setDate(4, despesa.getData());
            ps.setInt(5, despesa.getNumConta());
            ps.setInt(6, despesa.getNumCartao());
            System.out.println(despesa.getId() + " " + despesa.getDescricao() + " " + despesa.getValor() + " " + despesa.getData() + " " + despesa.getNumConta() + " " + despesa.getNumCartao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DespesaInserir.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

}
