// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.AssertionConcern;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Defines a persons name object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Embeddable
public class Name extends AssertionConcern implements Serializable {

    @Column(name = "firstName", length = 150, nullable = false)
    private String firstName;

    @Column(name = "middleName", length = 150)
    private String middleName;

    @Column(name = "lastName", length = 150, nullable = false)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        assertArgumentNotEmpty(firstName, "First Name cannot be null or empty.");
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        assertArgumentNotEmpty(lastName, "Last Name cannot be null or empty.");
        this.lastName = lastName;
    }
}
