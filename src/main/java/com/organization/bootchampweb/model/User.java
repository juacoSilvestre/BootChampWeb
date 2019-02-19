package com.organization.bootchampweb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User extends BasedNamedEntity implements Serializable {

    @NotNull(message = "Email cannot be null")
    @Email(message = "invalid email format")
    private String email;
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 50, message
            = "Username Me must be between 5 and 50 characters")
    private String userName;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Birthdate cannot be null")
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    //@JsonBackReference("user")
    @JsonManagedReference("user")
    // @JsonIgnore
    @OneToMany(mappedBy = "users" ,cascade = CascadeType.ALL)
    private Set<UserItem> userItems;

}
/*  @JsonBackReference //VER!! preventivo para evitar recursividad
    @ManyToMany
    @JoinTable(
            name="UserAndGames",
            joinColumns=@JoinColumn(name="users_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="games_id", referencedColumnName="id"))
    private List<Game> games ;
    */
/*
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
*/