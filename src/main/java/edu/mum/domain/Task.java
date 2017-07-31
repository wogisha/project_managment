package edu.mum.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @Embedded
    TimeFrame timeFrame;

    @Enumerated(EnumType.STRING)
    Statuses status;

    @OneToMany(cascade = CascadeType.ALL)
    List<Resource> resources = new ArrayList<>();


    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

