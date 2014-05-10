// Copyright 2014 Tool Inc.

package com.toolsoft.pulse;

import com.toolsoft.common.tenant.TenancyContext;
import com.toolsoft.common.tenant.TenancyHolderStrategy;
import com.toolsoft.common.tenant.domain.Tenant;

import org.junit.Before;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import org.junit.After;

/**
 * Defines a the behavior for the Tenant aware tests.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
public class TenantAwareTest extends PersistentTest {
    
    private PlatformTransactionManager tx;
    private TransactionStatus transactionStatus;
    protected boolean commit = true;
    
    @Before
    public void setup() {
        registerTenancyContext(createTenant(1));
        tx = getApplicationContext().getBean(PlatformTransactionManager.class);
        transactionStatus = tx.getTransaction(null);
    }
    
    @After
    public void shutdown() {
        if (commit) {
            tx.commit(transactionStatus);
        } else {
            tx.rollback(transactionStatus);
        }
    }

    public Tenant createTenant(int id) {
        return new Tenant(id);
    }

    private void registerTenancyContext(Tenant tenant) {
        TenancyHolderStrategy.registerTenancyContext(new TenancyContext(tenant));
    }

    public PlatformTransactionManager getPlatformTransactionManager() {
        return getApplicationContext().getBean(PlatformTransactionManager.class);
    }
}
