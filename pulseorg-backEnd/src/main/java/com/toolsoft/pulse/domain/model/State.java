// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Defines a state of a {@link com.toolsoft.pulse.domain.model.Country}.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@DiscriminatorValue("STATE")
public class State extends ReferenceDetail {
}
