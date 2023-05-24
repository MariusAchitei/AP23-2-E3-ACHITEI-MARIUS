package com.lab11.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {
    @Id
    private Long id;

    private String name;

    private Integer score;

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
    }
}
