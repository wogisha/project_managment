package edu.mum.domain;

import javax.persistence.*;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class AssetResource extends Resource {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
