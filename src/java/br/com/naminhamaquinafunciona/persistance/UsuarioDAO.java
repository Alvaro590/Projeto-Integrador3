/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;


import br.com.naminhamaquinafunciona.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() {
        this.connection = Conexao.getConnection();
    }

    public void inserirUsuario(Usuario obj) {

        try {
            String sql = "INSERT INTO usuario (login, senha) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getSenha());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario retornaUsuarioPorLogin(String login) {
        try {
            String sql = "SELECT * FROM usuario WHERE login= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario obj = new Usuario(rs.getInt("usuario_id"),rs.getString("login"), rs.getString("senha"));
                return obj;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
          
    
//    public void alterarObj(Usuario obj) {
//        try {
//            String sql = "UPDATE usuario SET login = ? WHERE id_banco = ? ";
//            PreparedStatement ps = connection.prepareStatement(sql);
//
//            ps.setString(1, obj.getDescricao());
//            ps.setInt(2, obj.getId());
//
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ObjetoDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    

}
