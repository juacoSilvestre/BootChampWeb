package com.organization.bootchampweb.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private OffsetDateTime creationDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @UpdateTimestamp
    private OffsetDateTime editionDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private OffsetDateTime deletionDate;

}
