package edu.mum.domain;

import javax.persistence.Entity;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class VolunterResource extends AssetResource {
    private String skill;


    public String getSkill() {

        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }


}
