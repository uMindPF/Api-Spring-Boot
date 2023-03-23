package com.uMind.uMind.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

    private String password;

    private String email;

    public Admin() {
    }

    public Admin(int id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = SecurityClass.hashSHA1(password);
        this.email = email;
    }
}
