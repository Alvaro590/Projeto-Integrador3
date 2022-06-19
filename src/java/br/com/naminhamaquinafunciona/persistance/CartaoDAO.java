/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.Cartao;

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
public class CartaoDAO {

    private Connection connection;

    public CartaoDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirCartao(Cartao obj) {

        try {
            String sql = "INSERT INTO cartao (numero, nome, bandeira, limite, agencia, user_id, numero_conta) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getNumero());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getBandeira());
            ps.setDouble(4, obj.getLimite());
            ps.setInt(5, obj.getAgencia());
            ps.setInt(6, obj.getUserId());
            ps.setInt(7, obj.getNumeroConta());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Cartao> listarCartao() {
        List<Cartao> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cartao";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Cartao obj = new Cartao();
                obj.setId(rs.getInt("cartao_id"));
                obj.setNumero(rs.getInt("numero"));
                obj.setNome(rs.getString("nome"));
                obj.setBandeira(rs.getString("bandeira"));
                obj.setLimite(rs.getDouble("limite"));
                obj.setAgencia(rs.getInt("agencia"));
                obj.setUserId(rs.getInt("user_id"));
                obj.setNumeroConta(rs.getInt("numero_conta"));
                lista.add(obj);

            }
            s.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Cartao retornaCartaoPorNumero(int numero) {
        try {
            String sql = "SELECT * FROM cartao WHERE numero= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cartao obj = new Cartao(rs.getInt("cartao_id"), rs.getInt("numero"), rs.getString("nome"), rs.getString("bandeira"), rs.getInt("limite"), rs.getInt("agencia"), rs.getInt("user_id"), rs.getInt("numero_conta"));
                return obj;
            }
    
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void alterarCartao(Cartao obj) {
        try {
            
            String sql = "UPDATE cartao SET nome = ?, bandeira = ?, limite = ?, agencia = ?, numero_conta = ? WHERE numero = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getBandeira());
            ps.setDouble(3, obj.getLimite());
            ps.setInt(4, obj.getAgencia());
            ps.setInt(5, obj.getNumeroConta());
            ps.setInt(6, obj.getNumero());

            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerCartao(int codigo) {
        try {
            String sql = "DELETE FROM cartao WHERE numero = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
