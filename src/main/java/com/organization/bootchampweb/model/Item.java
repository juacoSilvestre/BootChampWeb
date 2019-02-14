package com.organization.bootchampweb.model;


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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userItem_id")
    Set<UserItem> userItem;

}

