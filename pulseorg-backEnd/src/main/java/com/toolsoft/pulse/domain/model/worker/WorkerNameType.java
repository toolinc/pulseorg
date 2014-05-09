// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.pulse.domain.model.ReferenceTenant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Defines the supported types of work names.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Entity
@DiscriminatorValue("WORKER_NAME")
public class WorkerNameType extends ReferenceTenant {
}
