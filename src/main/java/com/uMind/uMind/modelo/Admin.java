package com.uMind.uMind.modelo;

import com.uMind.uMind.security.SecurityClass;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
