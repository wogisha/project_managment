package edu.mum.domain;

import javax.persistence.*;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Resource {

    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    private String name;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}