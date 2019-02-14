package com.organization.bootchampweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Description implements Serializable {
    @Size(max = 500, message
            = "Description must have between 0 and 500 characters")
    private String webDescription;
    @Size(max = 500, message
            = "Description must have between 0 and 500 characters")
    private String mobileDescription;
}
