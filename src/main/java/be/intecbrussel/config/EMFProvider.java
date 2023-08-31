package be.intecbrussel.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//EMF = Entity Manager Factory
public class EMFProvider {
    //fields & properties
    private static EntityManagerFactory entityManagerFactory; //Singleton


    //constructors
    private EMFProvider() {
    }


    //custom methods
    public static EntityManagerFactory getEMF() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysql"); //argument = <persistence-unit name="mysql"> in persistence.xml
        }

        return entityManagerFactory;
    }
}
