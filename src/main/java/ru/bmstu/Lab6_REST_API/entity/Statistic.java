package ru.bmstu.Lab6_REST_API.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_login", nullable = false)
    private String playerLogin;

    @Column(name = "game_name", nullable = false)
    private String gameName;

    @Column(name = "is_game_won", nullable = false)
    private Boolean isGameWon;


    protected Statistic() {
    }

    public Statistic(String playerLogin, String gameName, Boolean isGameWon) {
        this.playerLogin = playerLogin;
        this.gameName = gameName;
        this.isGameWon = isGameWon;
    }
}
