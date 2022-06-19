/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.Receita;
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
public class ReceitaDAO {

    private Connection connection;

    public ReceitaDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirReceita(Receita obj) {

        try {
            String sql = "INSERT INTO receita (receita_id, descricao, valor, data_receita, num_conta) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getDescricao());
            ps.setDouble(3, obj.getValor());
            ps.setDate(4, obj.getData());
            ps.setInt(5, obj.getNumConta());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Receita> listarReceita() {
        List<Receita> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM receita";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Receita obj = new Receita();
                obj.setDescricao(rs.getString("descricao"));
                obj.setId(rs.getInt("receita_id"));
                obj.setData(rs.getDate("data_receita"));
                obj.setNumConta(rs.getInt("num_conta"));                
                obj.setValor(rs.getDouble("valor"));
                lista.add(obj);
            }
            s.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterarReceita(Receita obj) {
        try {
            String sql = "UPDATE receita SET descricao = ?, valor=?, data_receita=?, num_conta=? WHERE receita_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, obj.getDescricao());
            ps.setDouble(2, obj.getValor());
            ps.setDate(3, obj.getData());
            ps.setInt(4, obj.getNumConta());
            ps.setInt(5, obj.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerReceita(int id) {
        try {
            String sql = "DELETE FROM receita WHERE receita_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Receita retornaReceitaPorId(int id) {
        try {
            String sql = "SELECT * FROM receita WHERE receita_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Receita obj = new Receita(rs.getInt("receita_id"), rs.getString("descricao"), rs.getDouble("valor"), rs.getDate("data_receita"), rs.getInt("num_conta"));
                return obj;
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
