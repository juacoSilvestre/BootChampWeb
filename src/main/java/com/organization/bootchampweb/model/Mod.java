package com.organization.bootchampweb.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="mods")
public class Mod extends Item implements Serializable {
    @JsonBackReference
    @ManyToOne(fetch= FetchType.LAZY )
    @JoinColumn(name = "game_id")
    private Game game;

    @DecimalMin(value = "0.0", message="The price should not be less than 0")
    private float price;


}

