// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.person;

import com.toolsoft.common.backend.domain.model.enablement.TenantRangeDateDomainObject;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Defines a person object.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends TenantRangeDateDomainObject {
}
