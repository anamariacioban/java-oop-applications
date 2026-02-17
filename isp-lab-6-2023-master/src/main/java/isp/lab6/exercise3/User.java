package isp.lab6.exercise3;

import java.util.Objects;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }
}
