package com.organization.bootchampweb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Entity
//@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class UserItem implements Serializable {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private OffsetDateTime transactionDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
   private Long id;

   // @JsonIgnore
    //@JsonBackReference(value = "user")
    //@JsonManagedReference("user")
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn

    //@JsonProperty("users")
    private User users;
    //@JsonBackReference(value = "game")
    //@JsonIgnore
    //@JsonManagedReference("game")
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn
    //@JsonProperty("games")
    private Item items;
}
/*  //@JsonSerialize
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   //@MapsId
   //@JoinColumn
   private User user;
    //@JsonSerialize
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   //@MapsId
   //@JoinColumn
   private Game game;
    */