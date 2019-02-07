package com.organization.bootchampweb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    private String description;
    private float calification;
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    public User userGames;
}
