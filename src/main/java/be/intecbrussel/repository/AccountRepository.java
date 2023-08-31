package be.intecbrussel.repository;

import java.util.List;
import java.util.Optional;
import be.intecbrussel.model.Account;

public class AccountRepository {
    public boolean createAccount(Account account) {

        return false;
    }

    public Account getAccount(String email) {
        return Optional.empty();
    }

    public void createManyAccounts(List<Account> accountList) {

    }
}
