// Copyright 2014 Tool Inc.

package com.toolsoft.pulse.infrastructure.inject;

import com.google.common.collect.ImmutableMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * Specifies the injection producer of the database test module.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@Configuration
public class DatabaseModule {

    @Bean
    @Named("jpaDialect")
    public JpaDialect providesJpaDialect() {
        return new EclipseLinkJpaDialect();
    }

    @Bean
    @Named("jpaProperties")
    public Map<String, Object> providesJpaProperties() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("eclipselink.id-validation", "NONE");
        builder.put("eclipselink.weaving", "false");
        builder.put("eclipselink.logging.level", "FINE");
        return builder.build();
    }

    @Bean
    @Named("dataSource")
    public DataSource providesDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/pulse_test");
        dataSource.setUsername("root");
        dataSource.setPassword("toor");
        return dataSource;
    }

    @Bean
    @Named("jpaVendorAdapter")
    public JpaVendorAdapter providesJpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabasePlatform(
                "org.eclipse.persistence.platform.database.MySQLPlatform");
        return jpaVendorAdapter;
    }

    @Bean
    @Named("entityManagerFactory")
    @Inject
    public LocalContainerEntityManagerFactoryBean providesEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("pulsePUTest");
        factoryBean.setDataSource(providesDataSource());
        factoryBean.setJpaDialect(providesJpaDialect());
        factoryBean.setJpaPropertyMap(providesJpaProperties());
        factoryBean.setJpaVendorAdapter(providesJpaVendorAdapter());
        factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factoryBean;
    }
}
