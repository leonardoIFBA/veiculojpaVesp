package com.example;

import java.util.List;

import com.example.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ListarVeiculos {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        Query query = manager.createQuery("from Veiculo");

        List<Veiculo> veiculos = query.getResultList();
        System.out.println("-----------------------------");
        for(Veiculo v : veiculos){
            System.out.println(v.getCodigo() + " - "
                + v.getFabricante() + " "
                + v.getModelo() + ", ano "
                + v.getAnoFabricacao() +"/"
                + v.getAnoModelo() + " por R$ "
                + v.getValor());
        }
        System.out.println("-------------------------------");

    }
}
