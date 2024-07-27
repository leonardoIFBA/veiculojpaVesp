package com.example;

import com.example.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ListarPorCodigo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

    Veiculo veiculo = manager.find(Veiculo.class, 2);
    EntityTransaction et = manager.getTransaction();
    et.begin();
    manager.remove(veiculo);
    et.commit();

    System.out.println("Veiculo de código " + veiculo.getCodigo()
        + "é um " + veiculo.getModelo());

    }
}
