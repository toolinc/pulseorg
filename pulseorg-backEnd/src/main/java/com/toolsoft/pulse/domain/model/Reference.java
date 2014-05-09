// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model;

import com.toolsoft.common.backend.domain.model.enablement.RangeDateDomainObject;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Defines the reference mapping for different domain objects.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@Table(name = "Reference")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 200, discriminatorType = DiscriminatorType.STRING)
public abstract class Reference extends RangeDateDomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReference")
    private BigInteger id;

    @Column(name = "code", length = 150)
    private String code;

    @Column(name = "displayName", length = 250)
    private String displayName;

    @Column(name = "description", length = 500)
    private String description;

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        assertArgumentNotNull(id, "Id cannot be null.");
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
