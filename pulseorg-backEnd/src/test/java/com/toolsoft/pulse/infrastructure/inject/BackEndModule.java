// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.infrastructure.inject;

import com.toolsoft.common.tenant.TenancyHolderStrategy;
import com.toolsoft.common.tenant.adapter.ThreadLocalTenancyStrategy;
import com.toolsoft.common.tenant.adapter.jpa.EntityManagerTenantAwareProvider;
import com.toolsoft.common.tenant.adapter.jpa.JpaTransactionManagerTenantAware;
import com.toolsoft.common.tenant.adapter.jpa.SharedEntityManagerTenancyAware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Specifies the injection producer of the transaction test module.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Configuration
@ComponentScan(basePackages = {"com.toolsoft"})
@EnableTransactionManagement
@Import(value = {DatabaseModule.class})
public class BackEndModule implements TransactionManagementConfigurer {

    static {
        TenancyHolderStrategy.setStrategy(new ThreadLocalTenancyStrategy());
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    @Named("jpaProperties")
    private Map<String, Object> jpaProperties;

    @Bean
    @Named("providerEntityManager")
    public Provider<EntityManager> providesProviderEntityManager() {
        EntityManagerTenantAwareProvider provider
                = new EntityManagerTenantAwareProvider(entityManagerFactory, jpaProperties);
        return provider;
    }

    @Bean
    @Named("entityManager")
    public SharedEntityManagerBean providesSharedEntityManagerBean() {
        SharedEntityManagerTenancyAware shared
                = new SharedEntityManagerTenancyAware(providesProviderEntityManager());
        shared.setEntityManagerFactory(entityManagerFactory);
        shared.setJpaPropertyMap(jpaProperties);
        return shared;
    }

    @Bean
    @Named("transactionManager")
    public JpaTransactionManager providesJpaTransactionManager() {
        JpaTransactionManagerTenantAware jpa
                = new JpaTransactionManagerTenantAware(entityManagerFactory, providesProviderEntityManager());
        return jpa;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return providesJpaTransactionManager();
    }
}
