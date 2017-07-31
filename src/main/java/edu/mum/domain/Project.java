package edu.mum.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wogisha on 30/07/2017.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String description;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<byte[]> descriptionFiles = new ArrayList<>();

    private String location;

    @Version
    private int version;

    @Enumerated(EnumType.STRING)
    private Statuses status;


    @Embedded
    private TimeFrame timeFrame;

    @OneToMany(fetch = FetchType.LAZY)

    private List<Beneficiary> beneficiaries = new ArrayList<>();


    @ElementCollection(fetch = FetchType.LAZY)
    private List<byte[]> beneficiaryFiles = new ArrayList<>();

    @OneToMany
    private List<Task> tasks = new ArrayList<>();

    @OneToMany
    private List<Beneficiary> volunters = new ArrayList<>();





    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<byte[]> getDescriptionFiles() {
        return descriptionFiles;
    }

    public void setDescriptionFiles(List<byte[]> descriptionFiles) {
        this.descriptionFiles = descriptionFiles;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public List<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public List<byte[]> getBeneficiaryFiles() {
        return beneficiaryFiles;
    }

    public void setBeneficiaryFiles(List<byte[]> beneficiaryFiles) {
        this.beneficiaryFiles = beneficiaryFiles;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Beneficiary> getVolunters() {
        return volunters;
    }

    public void setVolunters(List<Beneficiary> volunters) {
        this.volunters = volunters;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
