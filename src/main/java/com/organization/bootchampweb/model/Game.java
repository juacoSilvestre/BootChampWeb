package com.organization.bootchampweb.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;



@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Game extends Item implements Serializable {


    @DecimalMax(value = "10.0", message="Calification must be between 0.0 and 10.0")
    @DecimalMin(value = "0.0", message="Calification must be between 0.0 and 10.0")
    private float calification;
    @DecimalMin(value = "0.0", message="The price should not be less than 0")
    private float price;
    private String genre;
    //////@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mod_id")
    private Set<Mod> mods;


}

  /*  @ManyToMany
    @JoinTable(
   name="UserAndGames",
   joinColumns=@JoinColumn(name="games_id", referencedColumnName="id"),
   inverseJoinColumns=@JoinColumn(name="users_id",referencedColumnName="id"))
 private List<User> users;
*/