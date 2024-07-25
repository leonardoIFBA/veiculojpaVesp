package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    //Cria o objeto(factory) que inicializa a conexão com o banco de dados
    private static EntityManagerFactory factory;

    //bloco que será inicializado quando a classe for carregada na memóris
    static{
        //Retorna a fabrica de EntityManger (Objeto JPA resposável pelas operações do CRUD)
        factory = Persistence.createEntityManagerFactory("IFBA-PU");
    }

    //Este método retorna um objeto EntityManager
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    //fecha a conexão com o banco de dados
    public static void close(){
        factory.close();
    }


}
