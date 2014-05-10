// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.pulse.domain.model.person.Person;
import com.toolsoft.pulse.domain.model.person.PersonPhone;

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
 * Defines a worker phone object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@Table(name = "WorkerPhone", uniqueConstraints = {
        @UniqueConstraint(name = "WorkerPhone_UK",
                columnNames = {"idWorker", "idReferenceTenant"})})
public class WorkerPhone extends PersonPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorkerPhone")
    private BigInteger id;

    @JoinColumn(name = "idWorker", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerPhone_Worker_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Worker worker;

    @JoinColumn(name = "idReferenceTenant", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerPhone_WorkerPhoneType_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private WorkerPhoneType workerPhoneType;

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

    public WorkerPhoneType getWorkerPhoneType() {
        return workerPhoneType;
    }

    public void setWorkerPhoneType(WorkerPhoneType workerPhoneType) {
        assertArgumentNotNull(workerPhoneType, "Phone Type is cannot be null.");
        this.workerPhoneType = workerPhoneType;
    }

    @Override
    public Person getPerson() {
        return getWorker();
    }
}
