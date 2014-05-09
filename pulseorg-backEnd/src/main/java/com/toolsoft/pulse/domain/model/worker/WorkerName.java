// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.pulse.domain.model.person.Person;
import com.toolsoft.pulse.domain.model.person.PersonName;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Defines a worker object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@Table(name = "WorkerName", uniqueConstraints = {
        @UniqueConstraint(name = "WorkerName_UK",
                columnNames = {"idWorker", "idReferenceTenant"})})
public class WorkerName extends PersonName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorkerName")
    private BigInteger id;

    @JoinColumn(name = "idWorker", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerName_Worker_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Worker worker;

    @JoinColumn(name = "idReferenceTenant", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerName_WorkerNameType_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private WorkerNameType workerNameType;

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        assertArgumentNotNull(id, "The id is null.");
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        assertArgumentNotNull(worker, "Worker is null.");
        this.worker = worker;
    }

    public WorkerNameType getWorkerNameType() {
        return workerNameType;
    }

    public void setWorkerNameType(WorkerNameType workerNameType) {
        assertArgumentNotNull(workerNameType, "Name type cannot be null.");
        this.workerNameType = workerNameType;
    }

    @Override
    public Person getPerson() {
        return getWorker();
    }
}
