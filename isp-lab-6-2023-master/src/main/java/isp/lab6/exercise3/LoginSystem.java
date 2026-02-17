package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginSystem {
    private Set<User> users = new HashSet<>();
    private List<User> userList;
    private OnlineStore store;

    public LoginSystem(OnlineStore store) {
        this.userList = new ArrayList<>();
        this.store = store;
    }

    public void register(String username, String password) {
        List<User> userList = new ArrayList<>(users);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                System.out.println("Username already taken.");
                return;
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful!");
    }

    public boolean login(String username, String password) {
        List<User> userList = new ArrayList<>(users);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)) {
                store.addSession(username);
                return true;
            }
        }
        return false;
    }

    public boolean logout(String username) {
        List<User> userList = new ArrayList<>(users);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                store.removeSession(username);
                return true;
            }
        }
        return false;
    }

}