/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SGP.testes;

import br.com.SGP.model.dao.UsuarioDAO;
import br.com.SGP.model.entities.Usuario;

/**
 *
 * @author lucas
 */
public class TesteUsuario {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        
       user.setId(2);
       user.setNomeUsuario("Lucas");
       user.setSenha("123456");
              
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserirUsuario(user);
}}
