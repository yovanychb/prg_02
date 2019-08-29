/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ues.occ.edu.sv.ingenieria.prn335.guia02.Clasificacion;

/**
 *
 * @author yovany
 */
public class ClasificacionBean implements Serializable {

    protected EntityManager em;

    private void getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinePU");
        em = emf.createEntityManager();
    }

    private EntityTransaction getTx() {
        if (em != null) {
            return em.getTransaction();
        }
        return null;
    }

    public void create(Clasificacion clasificacion) {
        EntityTransaction tx = this.getTx();
        if (clasificacion != null && tx != null) {
            try {
                tx.begin();
                this.em.persist(clasificacion);
                tx.commit();
            } finally {
                if (this.em != null) {
                    this.em.close();
                }
            }
        }
    }

    public void update(Clasificacion clasificacion) {
        EntityTransaction tx = this.getTx();
        if (clasificacion != null && tx != null) {
            try {
                tx.begin();
                this.em.merge(clasificacion);
                tx.commit();
            } catch (Exception ex) {

            }
        }
    }
}
