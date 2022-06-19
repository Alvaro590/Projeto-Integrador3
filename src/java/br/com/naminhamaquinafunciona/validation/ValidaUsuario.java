/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.validation;

import br.com.naminhamaquinafunciona.model.Usuario;
import br.com.naminhamaquinafunciona.model.interfaces.Mediator;
import br.com.naminhamaquinafunciona.persistance.UsuarioDAO;

/**
 *
 * @author Usuário
 */
public class ValidaUsuario implements Mediator {

    public boolean validaSenha(String senha) {

        return senha.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,12}$");
    }

    public boolean validaUsuario(String usuario) {

        return (usuario.length() > 3 && usuario.length() < 15);
    }
    UsuarioDAO userDAO = new UsuarioDAO();

    @Override
    public boolean login(String usuario, String senha) {
        if (validaUsuario(usuario) && validaSenha(senha)) {
            Usuario user = userDAO.retornaUsuarioPorLogin(usuario);
            if (user != null && user.getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }

    public int RetornaIdUser(String login) {
        return userDAO.retornaUsuarioPorLogin(login).getId();
    }
}
