package be.intecbrussel.service;

import be.intecbrussel.model.Account;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.UserRepository;

public class UserService {

    private AccountService accountService = new AccountService();
    private UserRepository userRepository = new UserRepository();

    public boolean createUser(User user) {

        boolean success = accountService.createAccount(user.getAccount());
        if (success) {
            userRepository.createUser(user);
        }

        return false;
    }

    public User getUser(String email) {
        Account account = accountService.getAccount(email);

        //if (account.isPresent()) {
            //Account foundAccount = account.get();
            //User user = userRepository.getUser(foundAccount);

            //return user;
        //} else {
            return null;
        }

    public void createManyUsers(){
        //List <Account> accounts = new ArrayList<>();
        //List<User> users = new ArrayList<>();
        //UserService userService = new UserService();

        //for (User user: userList) {
            //accounts.add(user.getAccount());
        //}
        //accountService.createManyAccounts(accounts);
    }
}
