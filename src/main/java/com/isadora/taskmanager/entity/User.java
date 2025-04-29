package com.isadora.taskmanager.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @ManyToMany(mappedBy = "members")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "responsible")
    private List<Task> tasks = new ArrayList<>();

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }

    public void setPassword(String encodedPassword) {
    }

    public String getPassword() {
        return "";
    }
}
