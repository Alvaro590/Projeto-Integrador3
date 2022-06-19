/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class BancoDAO {

    private Connection connection;

    public BancoDAO() {
        this.connection = Conexao.getConnection();
    }
    
    

    public void inserirBanco(Banco banco) {
        
        try {
            String sql = "INSERT INTO banco (banco_id, descricao) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, banco.getId());
            ps.setString(2, banco.getDescricao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public List<Banco> listarBancos() {
        List<Banco> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM banco";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Banco banco = new Banco(rs.getInt("banco_id"), rs.getString("descricao"));
                lista.add(banco);
                
            }
            
            s.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterarBanco(Banco obj) {
        try {
            String sql = "UPDATE banco SET descricao = ? WHERE banco_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, obj.getDescricao());
            ps.setInt(2, obj.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerBanco(int codigo) {
        try {
            String sql = "DELETE FROM banco WHERE banco_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Banco retornaBancoPorDescricao(String descricao) {
        try {
            String sql = "SELECT * FROM banco WHERE descricao= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descricao);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Banco obj = new Banco(rs.getInt("banco_id"), rs.getString("descricao"));
                return obj;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Banco retornaBancoPorId(int id) {
        try {
            String sql = "SELECT * FROM banco WHERE banco_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                Banco obj = new Banco(rs.getInt("banco_id"), rs.getString("descricao"));
                return obj;
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

}
