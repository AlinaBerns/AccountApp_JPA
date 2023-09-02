package be.intecbrussel.repository;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Account;
import jakarta.persistence.EntityManager;

public class AccountRepository {
    public boolean createAccount(Account account) {
            EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
            entityManager.close();

        return true;
    }

    public Optional<Account> getAccount(String email) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class,email);
        em.getTransaction().commit();
        em.close();

        System.out.println(account);
        return Optional.ofNullable(account);
    }

    public void updateAccount(Account account) {
        EntityManager em = EMFProvider.getEMF().createEntityManager();

        em.getTransaction().begin();
        em.merge(account);

        if(account.getEmail() != null){
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }
        em.close();

        System.out.println("UPDATE "+ account);
    }


    public void deleteAccount(String e) {
            EntityManager em = EMFProvider.getEMF().createEntityManager();

            em.getTransaction().begin();

            if (e != null){
                em.remove(em.find(Account.class, e));
                em.getTransaction().commit();
            }else {
                em.getTransaction().rollback();
            }
        em.close();
    }

    public void changePassword(Account account, String newPassword) {
        EntityManager entityManager = EMFProvider.getEMF().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("NEW PASSWORD: " + account.getPassw());
    }

    public void createManyAccounts (List<Account> accountList){
    }
}
