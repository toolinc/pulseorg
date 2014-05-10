// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.domain.model.DomainObject;

import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Defines a person address number object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonAddress extends DomainObject {

    @Embedded
    private Address address;

    public abstract Person getPerson();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        assertArgumentNotNull(address, "Address cannot be null.");
        this.address = address;
    }
}
