// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.pulse.domain.model.person.Person;
import com.toolsoft.pulse.domain.model.person.PersonAddress;

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
 * Defines a worker address object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@Table(name = "WorkerAddress", uniqueConstraints = {
        @UniqueConstraint(name = "WorkerAddress_UK",
                columnNames = {"idWorker", "idReferenceTenant"})})
public class WorkerAddress extends PersonAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorkerAddress")
    private BigInteger id;

    @JoinColumn(name = "idWorker", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerAddress_Worker_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Worker worker;

    @JoinColumn(name = "idReferenceTenant", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerAddress_WorkerAddressType_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private WorkerAddressType workerAddressType;

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

    public WorkerAddressType getWorkerAddressType() {
        return workerAddressType;
    }

    public void setWorkerAddressType(WorkerAddressType workerAddressType) {
        assertArgumentNotNull(workerAddressType, "Address Type is cannot be null.");
        this.workerAddressType = workerAddressType;
    }

    @Override
    public Person getPerson() {
        return getWorker();
    }
}
