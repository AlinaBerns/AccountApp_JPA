package be.intecbrussel.model;

import be.intecbrussel.util.IdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Optional;

@Entity
public class User {

    private long id;
    private String fname;
    private String lname;

    @Id
    @OneToOne
    private Account account;

    protected User(){

    }

    public User(long id, String fname, String lname, Account account) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.account = account;
    }

    public User(String fname, String lname, Account account) {
        this(IdGenerator.generateID(), fname, lname, account);
        this.fname = fname;
        this.lname = lname;
        this.account = account;

    }

    public long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
    this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
    this.lname = lname;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", account=" + account +
                '}';
    }
}
