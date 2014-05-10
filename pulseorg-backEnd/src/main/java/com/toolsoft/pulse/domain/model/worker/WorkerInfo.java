// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.common.backend.domain.model.DomainObject;

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

/**
 * Defines a worker information object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@Table(name = "WorkerInfo")
public class WorkerInfo extends DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idWorkerInfo")
    private BigInteger id;

    @JoinColumn(name = "idWorker", nullable = false,
            foreignKey = @ForeignKey(name = "WorkerName_Worker_FK"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Worker worker;

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        assertArgumentNotNull(id, "The id is null.");
        this.id = id;
    }
}
