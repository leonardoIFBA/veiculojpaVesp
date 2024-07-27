package com.example.repository;

import java.util.List;

import com.example.JpaUtil;
import com.example.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class Veiculos {
    private EntityManager manager;

    public Veiculos(){
        this.manager = JpaUtil.getEntityManager();
    }

    public void adicionar(Veiculo veiculo){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(veiculo);
        tx.commit();
    }

    public void atualizar(Veiculo veiculo){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(veiculo);
        tx.commit();
    }

    public void excluir(Veiculo veiculo){
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(veiculo);
        tx.commit();
    }

    public List<Veiculo> listarTodos(){
        TypedQuery<Veiculo> query = manager.createQuery(
            "from Veiculo", Veiculo.class);
        return query.getResultList(); 
    }

    public Veiculo porId(Long codigo){
        return manager.find(Veiculo.class, codigo);
    }
}
