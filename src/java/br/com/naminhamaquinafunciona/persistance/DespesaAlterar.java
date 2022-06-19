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
public class DespesaAlterar extends DespesaAbstract{
    
    private Connection connection=Conexao.getConnection();
    
    @Override
    public void executarMetodo(Despesa despesa) {
       //            id 
//	descricao
//	valor
//	data_despesa 
//	num_conta 
//	num_cartao 
        try {
            String sql = "UPDATE despesa SET descricao = ?, valor=?, data_despesa=?, num_conta=?, num_cartao=? WHERE id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, despesa.getData());
            ps.setInt(4, despesa.getNumConta());
            ps.setInt(5, despesa.getNumCartao());
            ps.setInt(6, despesa.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
