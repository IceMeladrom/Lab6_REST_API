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
@Table(name = "map_data")
public class MapData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "player_login", nullable = false)
    private String playerLogin;

    protected MapData() {
    }

    public MapData(String playerLogin) {
        this.playerLogin = playerLogin;
    }
}
