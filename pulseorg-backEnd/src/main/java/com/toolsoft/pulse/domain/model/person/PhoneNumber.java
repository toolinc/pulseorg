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
public class PhoneNumber extends AssertionConcern implements Serializable {

    @Column(name = "countryCode", length = 25)
    private String country;

    @Column(name = "areaCode", length = 25)
    private String area;

    @Column(name = "number", length = 25)
    private String number;

    @Column(name = "extension", length = 25)
    private String extension;
}
