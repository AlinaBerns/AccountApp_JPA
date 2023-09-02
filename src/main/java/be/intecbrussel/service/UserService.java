package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private AccountService accountService = new AccountService();
    private UserRepository userRepository = new UserRepository();

    public boolean createUser(User user) {

        boolean success = accountService.createAccount(user.getAccount());
        if (success) {
            userRepository.createUser(user);
        }
        return true;
    }

    public Optional<User> getUser(String e) {
        Optional<Account> accountt = accountService.getAccount(e);

        if (accountt.isPresent()) {
            Account foundAccount = accountt.get();
            return userRepository.getUser(foundAccount);
        } else {
            return Optional.empty();
        }
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    public void createManyUsers (List<User> users) {
        userRepository.createManyUsers(users);
    }
}

