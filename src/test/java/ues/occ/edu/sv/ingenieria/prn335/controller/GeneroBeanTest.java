/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.guia02.Genero;

/**
 *
 * @author yovany
 */
@ExtendWith(MockitoExtension.class)
public class GeneroBeanTest {

    Genero genero = new Genero();
    EntityManager EMmock;
    GeneroBean bean;

    public void inicio() {
        EMmock = Mockito.mock(EntityManager.class);
        EntityTransaction TXmock = Mockito.mock(EntityTransaction.class);
        Mockito.when(EMmock.getTransaction()).thenReturn(TXmock);
        bean = new GeneroBean();
        bean.em = EMmock;
    }

    @Test
    public void createTest() {
        inicio();
        bean.create(genero);
        Mockito.verify(EMmock, Mockito.times(1)).persist(genero);
    }

    @Test
    public void updateTest() {
        inicio();
        bean.update(genero);
        Mockito.verify(EMmock, Mockito.times(1)).merge(genero);
    }

    @Test
    public void generosFiltradosTest() {
        GeneroBean gen = new GeneroBean();
        List<Genero> lista = gen.generosFiltrados("drama comedia romance acción terror musical horror ficción guerra western\n"
                + "crimen psicológico suspenso noir blanco&negro biográfico");

        for (Genero genero1 : lista) {
            System.out.println(genero1.getNombre());
        }
    }

}
