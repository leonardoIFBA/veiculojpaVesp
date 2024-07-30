package com.example;

import javax.swing.text.html.parser.Entity;

import com.example.model.Cliente;
import com.example.model.Veiculo;
import com.example.repository.Clientes;
import com.example.repository.Veiculos;
import com.mysql.cj.xdevapi.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*Veiculo v = new Veiculo();
        v.setCodigo(4L);
        v.setFabricante("BMW");
        v.setModelo("X2");
        v.setAnoFabricacao(2024);
        v.setAnoModelo(2024);
        v.setValor(250000D);

        Veiculos veiculos = new Veiculos();
        veiculos.adicionar(v);
        veiculos.listarTodos();
        
        Veiculo veiculo = veiculos.porId(1L);
        veiculos.excluir(veiculo);

        veiculos.listarTodos(); */

        Cliente c = new Cliente();
        c.setNome("Leonardo");
        c.setCpf("33344455566");
        c.setTelefone("77999998888");
        c.setEndereco("leonardo@mail.com");
        c.setEndereco("Rua A");

        Clientes clientes = new Clientes();
        clientes.adicionar(c);


        //EntityManagerFactory entityManagerFactory = Persistence.
        //    createEntityManagerFactory("IFBA-PU");

        /*EntityManager manager = entityManagerFactory.createEntityManager();
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(v);
        tx.commit();*/
        
        //entityManagerFactory.close();
    }
}