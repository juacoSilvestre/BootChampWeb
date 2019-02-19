package com.organization.bootchampweb.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class Item extends BasedNamedEntity implements Serializable {

    @Embedded
    private Description description;
    @JsonIgnore
    //@JsonBackReference("game")
    ////////@JsonManagedReference("game")
    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private Set<UserItem> userItems;

}

