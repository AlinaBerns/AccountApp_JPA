package be.intecbrussel.repository;
import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    public boolean createUser(User user) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
        return user.getId() != 0;
    }

    public Optional <User> getUser(Account account) {
            EntityManager em = EMFProvider.getEMF().createEntityManager();
            em.getTransaction().begin();
            User user = em.find(User.class, account.getEmail());
            em.getTransaction().commit();
            em.close();
            return Optional.ofNullable(user);
    }
    public void createManyUsers (List<User> users) {
    }

    public boolean deleteUser(User user) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(User.class, user.getId()));
        em.getTransaction().commit();

        em.close();

        return false;
    }

    public boolean updateUser(User user) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        User userTest = em.merge(user);
        if (user.getId() != userTest.getId()) {
            em.getTransaction().rollback();
            em.close();
            return false;
        } else {
            em.getTransaction().commit();
            em.close();
            return true;
        }
    }
}
