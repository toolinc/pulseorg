// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Defines a country.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@DiscriminatorValue("COUNTRY")
public class Country extends Reference {
}
