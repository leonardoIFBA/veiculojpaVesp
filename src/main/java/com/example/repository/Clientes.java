package com.example.repository;

import java.util.List;

import com.example.JpaUtil;
import com.example.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class Clientes {
    private EntityManager manager;

    // Construtor da classe inicializa o EntityManager para manipular o objeto Veículo
    public Clientes(){
        this.manager = JpaUtil.getEntityManager();
    }

    // Adiciona um cliente no banco de dados
    public void adicionar(Cliente cliente){
        // Cria uma transação 
        EntityTransaction et = manager.getTransaction();
        et.begin();  // Inicializa a transação
        manager.persist(cliente);
        et.commit();  // Confirma a transação, ou seja, grava no banco de dados
    }

    // Altera um cliente no banco de dados
    public void atualizar(Cliente cliente){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(cliente);
        tx.commit();
    }

    // Exclui um cliente no banco de dados
    public void excluir(Cliente cliente){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(cliente);
        tx.commit();
    }

    // Lista todos os clientes cadastrados no banco de dados
    public List<Cliente> listarTodos(){
        // Cria a consulta que será executada no banco de dados
        TypedQuery<Cliente> query = manager.createQuery(
            "from Cliente", Cliente.class);
        return query.getResultList(); 
    }

    // Retorna um cliente do banco de dados, de acordo o código passado
    public Cliente porId(Long codigo){
        return manager.find(Cliente.class, codigo);
    }
}
