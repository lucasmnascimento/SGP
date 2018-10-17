/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.java.cadastro.model.dao;

import br.com.devmedia.java.cadastro.model.entities.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class UsuarioDAO {

    public Usuario getUsuario(String nomeUsuario, String senha) {
        EntityManager em = new ConnectionFactory().getEntityManager();
        Usuario usuario = null;
        try {
            usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
                    .setParameter("name", nomeUsuario)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public Usuario inserirUsuario(Usuario usuario) {
        EntityManager em = new ConnectionFactory().getEntityManager();
        try {
            em.getTransaction().begin();

            if (usuario.getId() == null) {
                em.persist(usuario);
            } else {
                em.merge(usuario);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuario;
    }

    public Usuario deletarUsuario(Integer id) {
        EntityManager em = new ConnectionFactory().getEntityManager();
        Usuario usuario = null;
        
        try{
            
            usuario = em.find(Usuario.class, id);
            
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
            
        }catch(Exception e){
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return usuario;
        
    }

}