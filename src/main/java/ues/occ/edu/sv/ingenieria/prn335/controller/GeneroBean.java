/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.guia02.Genero;

/**
 *
 * @author yovany
 */
public class GeneroBean implements Serializable {

    protected EntityManager em;

    private void getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinePU");
        this.em = emf.createEntityManager();
    }

    private EntityTransaction getTx() {
        if (this.em != null) {
            return em.getTransaction();
        }
        return null;
    }

    public void create(Genero genero) {
        EntityTransaction tx = this.getTx();
        if (genero != null && tx != null) {
            try {
                tx.begin();
                this.em.persist(genero);
                tx.commit();
            } catch (Exception ex) {

            }
        }
    }

    public void update(Genero genero) {
        EntityTransaction tx = this.getTx();
        if (genero != null && tx != null) {
            try {
                tx.begin();
                this.em.merge(genero);
                tx.commit();
            } catch (Exception ex) {

            }
        }
    }

    public List<Genero> generosFiltrados(String Generos) {
        List<Genero> Nombre = new ArrayList<>();
        String[] generos = Generos.split(" ");
        String regexp = "[^\\w\\s[^aeiouAEIOU]]|(.)\\1";
        for (String genero : generos) {
            System.out.println(genero + " -> " + Pattern.matches(Pattern.compile(regexp).pattern(), genero));
            if (Pattern.matches(regexp, genero)) {
                System.out.println(genero);
                Genero item = new Genero();
                item.setNombre(genero);
                Nombre.add(item);
            }
        }
        return Nombre;
    }
}
