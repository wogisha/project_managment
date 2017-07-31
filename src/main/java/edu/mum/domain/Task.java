package edu.mum.domain;

import javax.persistence.*;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    TimeFrame timeFrame;

    @Enumerated(EnumType.STRING)
    Statuses status;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

