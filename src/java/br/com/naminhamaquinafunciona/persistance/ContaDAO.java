/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;


import br.com.naminhamaquinafunciona.model.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class ContaDAO {
    
    private Connection connection;

    public ContaDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirConta(Conta obj) {

        try {
            String sql = "INSERT INTO conta (numero, saldo, limite, user_id) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getNumero());
            ps.setDouble(2, obj.getSaldo());
            ps.setDouble(3, obj.getLimite());
            ps.setInt(4, obj.getUserId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public List<Conta> listarConta() {
        List<Conta> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM conta";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Conta obj = new Conta();
                obj.setId(rs.getInt("conta_id"));
                obj.setNumero(rs.getInt("numero"));
                obj.setSaldo(rs.getDouble("saldo"));
                obj.setLimite(rs.getDouble("limite"));
                obj.setUserId(rs.getInt("user_id"));
                lista.add(obj);
            }
            s.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterarConta(Conta obj) {
        try {
            String sql = "UPDATE conta SET limite = ? SET saldo = ? WHERE numero = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDouble(1, obj.getLimite());
            ps.setDouble(2, obj.getSaldo());
            ps.setInt(3, obj.getNumero());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerConta(int codigo) {
        try {
            String sql = "DELETE FROM conta WHERE numero = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Conta retornaContaPorNumero(int numero) {
        try {
            String sql = "SELECT * FROM conta WHERE numero= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numero);
            
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                Conta obj = new Conta(rs.getInt("conta_id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getDouble("limite"), rs.getInt("user_id"));
                return obj;
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Conta retornaContaPorId(int id) {
        try {
            String sql = "SELECT * FROM conta WHERE conta_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                Conta obj = new Conta(rs.getInt("conta_id"), rs.getInt("numero"), rs.getDouble("saldo"), rs.getDouble("limite"), rs.getInt("user_id"));
                return obj;
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
