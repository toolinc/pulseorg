// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.domain.model.DomainObject;

import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Defines a persons name object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonName extends DomainObject {

    @Embedded
    private Name name;

    public abstract Person getPerson();

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        assertArgumentNotNull(name, "Name cannot be null.");
        this.name = name;
    }
}
