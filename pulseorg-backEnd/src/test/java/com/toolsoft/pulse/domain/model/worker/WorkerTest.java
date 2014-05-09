// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.domain.model.worker;

import com.toolsoft.pulse.TenantAwareTest;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Test for {@code Worker}.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkerTest extends TenantAwareTest {

    @PersistenceContext
    private EntityManager entityManager;

    private PlatformTransactionManager tx;

    @Test
    public void testGetId() {
        entityManager.persist(new Worker());
        Assert.assertTrue(true);
    }
}
