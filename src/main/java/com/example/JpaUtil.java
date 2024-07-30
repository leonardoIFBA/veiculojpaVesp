package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory factory;

    //bloco que será inicializado quando a classe for carregada na memóris
    static{
        //classe Persistence é responsável por carregar o XML e inicializar as configurações do JPA
        //Retorna a fabrica de EntityManger (Objeto JPA resposável pelas operações do CRUD)
        factory = Persistence.createEntityManagerFactory("IFBA-PU");
    }

    public static EntityManager getEntityManager(){
        // Retona um EntityManager da fabrica instanciada acima
        // O EntityMager será responsavel pelas operações do CRUD
        return factory.createEntityManager();
    }

    //Fecha as configurações da fabrica
    public static void close(){
        factory.close();
    }


}
