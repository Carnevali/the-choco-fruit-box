package com.wine.gallery.models.chocolates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by felipecarnevalli on 9/9/18.
 */

@Entity
@Table(name="fruits")
@JsonIgnoreProperties( ignoreUnknown = true )
public class Fruits implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="description", nullable=false)
    private String description;

    @Column(name="date_created", nullable=false)
    private Date dateCreated;

    public Fruits() {

    }

    public Fruits(String description) {
        super();

        this.description = description;
        this.dateCreated = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}