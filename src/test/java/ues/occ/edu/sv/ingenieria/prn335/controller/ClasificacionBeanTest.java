/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ues.occ.edu.sv.ingenieria.prn335.guia02.Clasificacion;

/**
 *
 * @author yovany
 */
@ExtendWith(MockitoExtension.class)
public class ClasificacionBeanTest {
    
    public ClasificacionBeanTest() {
    }

    Clasificacion clasificacion = new Clasificacion();
    EntityManager EMmock;
    ClasificacionBean bean;
    
    public void inicio(){
        EMmock = Mockito.mock(EntityManager.class);
        EntityTransaction TXmock = Mockito.mock(EntityTransaction.class);
        Mockito.when(EMmock.getTransaction()).thenReturn(TXmock);
        bean = new ClasificacionBean();
        bean.em = EMmock;
    }

    @org.junit.jupiter.api.Test
    public void createTest(){
        inicio();
        bean.create(clasificacion);
        Mockito.verify(EMmock, Mockito.times(1)).persist(clasificacion);
    }
    
    @org.junit.jupiter.api.Test
    public void updateTest(){
        inicio();
        bean.update(clasificacion);
        Mockito.verify(EMmock, Mockito.times(1)).merge(clasificacion);
    }
    
}
