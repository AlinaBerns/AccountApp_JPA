package be.intecbrussel.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Objects;

@Entity
public class Account {

    @Id
    private String email;
    private String passw;

    protected Account(){

    }

    public Account(String email, String passw) {
        this.email = email;
        this.passw = passw;
    }

    public String getEmail() {
        return email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email) && Objects.equals(passw, account.passw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, passw);
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }
}
