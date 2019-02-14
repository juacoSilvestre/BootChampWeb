package com.organization.bootchampweb.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserItem implements Serializable {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    private OffsetDateTime transactionDate;
    /*
   @Id
   @Column(unique = true, nullable = false)
   private Long userId;
   @Id
   @Column(unique = true, nullable = false)
   private Long gameId;
   /*

   @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
   //@MapsId
   //@JoinColumn
   private User user;
   @Id
   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   //@MapsId
   //@JoinColumn
   private Item item;
   */
    @Id
    @ManyToOne(fetch= FetchType.LAZY )
    @JoinColumn(name = "user_id")
    private User users;
    @Id
    @ManyToOne(fetch= FetchType.LAZY )
    @JoinColumn(name = "game_id")
    private Game games;
}
