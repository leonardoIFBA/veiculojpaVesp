package com.example.repository;

import java.util.List;

import com.example.JpaUtil;
import com.example.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class Veiculos {
    private EntityManager manager;

    // Construtor da classe inicializa o EntityManager para manipular o objeto Veículo
    public Veiculos(){
        this.manager = JpaUtil.getEntityManager();
    }

    // Adiciona um veiculo no banco de dados
    public void adicionar(Veiculo veiculo){
        // Cria uma transação 
        EntityTransaction et = manager.getTransaction();
        et.begin();  // Inicializa a transação
        manager.persist(veiculo);
        et.commit();  // Confirma a transação, ou seja, grava no banco de dados
    }

    // Altera um veiculo no banco de dados
    public void atualizar(Veiculo veiculo){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(veiculo);
        tx.commit();
    }

    // Exclui um veiculo no banco de dados
    public void excluir(Veiculo veiculo){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(veiculo);
        tx.commit();
    }

    // Lista todos os veiculos cadastrados no banco de dados
    public List<Veiculo> listarTodos(){
        // Cria a consulta que será executada no banco de dados
        TypedQuery<Veiculo> query = manager.createQuery(
            "from Veiculo", Veiculo.class);
        return query.getResultList(); 
    }

    // Retorna um veiculo do banco de dados, de acordo o código passado
    public Veiculo porId(Long codigo){
        return manager.find(Veiculo.class, codigo);
    }
}
