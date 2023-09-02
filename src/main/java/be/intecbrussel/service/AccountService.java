package be.intecbrussel.service;

import be.intecbrussel.config.EMFProvider;
import be.intecbrussel.model.Account;
import be.intecbrussel.repository.AccountRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();
    public boolean createAccount(Account account) {
        return accountRepository.createAccount(account);
    }

    public Optional<Account> getAccount(String e) {
        return accountRepository.getAccount(e);
    }

    public boolean deleteAccount(String e){
        accountRepository.deleteAccount(e);
        return true;
    }

    public boolean updateAccount(Account account){
        accountRepository.updateAccount(account);
        return true;
    }

    public void createManyAccounts(List<Account> accountList) {
        accountRepository.createManyAccounts(accountList);
    }

}
