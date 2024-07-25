package com.example;

import javax.swing.text.html.parser.Entity;

import com.example.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Veiculo v = new Veiculo();
        v.setCodigo(4L);
        v.setFabricante("BMW");
        v.setModelo("X2");
        v.setAnoFabricacao(2024);
        v.setAnoModelo(2024);
        v.setValor(250000D);

        //EntityManagerFactory entityManagerFactory = Persistence.
        //    createEntityManagerFactory("IFBA-PU");

        //EntityManager manager = entityManagerFactory.createEntityManager();
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(v);
        tx.commit();
        
        //entityManagerFactory.close();
    }
}