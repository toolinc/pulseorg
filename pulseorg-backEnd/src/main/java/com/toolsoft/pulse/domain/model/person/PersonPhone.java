// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.domain.model.DomainObject;

import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Defines a person phone number object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonPhone extends DomainObject {

    @Embedded
    private PhoneNumber phoneNumber;

    public abstract Person getPerson();

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        assertArgumentNotNull(phoneNumber, "Phone number cannot be null.");
        this.phoneNumber = phoneNumber;
    }
}
