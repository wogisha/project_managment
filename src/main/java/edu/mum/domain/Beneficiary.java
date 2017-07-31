package edu.mum.domain;

import javax.persistence.*;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class Beneficiary {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private BeneficiaryRole role;


    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

