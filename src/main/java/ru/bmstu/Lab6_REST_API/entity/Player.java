package ru.bmstu.Lab6_REST_API.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "player")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", nullable = false)
    private String userLogin;

    @Column(name = "login", nullable = false)
    private String login;

    protected Player() {
    }

    public Player(String userLogin, String playerLogin) {
        this.userLogin = userLogin;
        this.login = playerLogin;
    }
}
