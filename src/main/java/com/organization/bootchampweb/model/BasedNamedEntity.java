package com.organization.bootchampweb.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;


@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BasedNamedEntity extends BaseEntity implements Serializable {
   private String name;


}
