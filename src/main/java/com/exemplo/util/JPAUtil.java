package com.exemplo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "bibliotecaPU";
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            System.err.println("Erro ao criar EntityManagerFactory: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
