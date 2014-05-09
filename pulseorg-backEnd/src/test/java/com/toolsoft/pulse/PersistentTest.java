// Copyright 2014 Tool Inc.

package com.toolsoft.pulse;

import com.toolsoft.pulse.infrastructure.inject.BackEndModule;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

/**
 * Specifies the behavior of the persistence tests.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BackEndModule.class},
        loader = AnnotationConfigContextLoader.class)
public class PersistentTest {

    @Inject
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @Deployment public static WebArchive createDeployment() {
    WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
    .addPackage("com.toolsoft.pulse.domain")
    .addPackage("com.toolsoft.pulse.domain.model")
    .addPackage("com.toolsoft.pulse.domain.model.applicant")
    .addPackage("com.toolsoft.pulse.domain.model.person")
    .addPackage("com.toolsoft.pulse.domain.model.worker")
    .addPackage("com.toolsoft.pulse.domain.repository")
    .addPackage("com.toolsoft.pulse.domain.service")
    .addClass(BackEndModule.class)
    .addClass(PersistentTest.class)
    .addClass(WorkerTest.class)
    .addAsLibraries(
    DependencyResolvers.use(MavenDependencyResolver.class)
    .goOffline()
    .artifact("com.google.guava:guava:13.0.1")
    .artifact("org.eclipse.persistence:eclipselink:2.5.1")
    .artifact("org.jboss.slf4j:slf4j-jboss-logmanager:1.0.3.GA")
    .artifact("com.toolsoft:common-backend:1.0")
    .artifact("com.toolsoft:tenant-backend:1.0")
    .resolveAsFiles())
    .addAsWebInfResource("ValidationMessages.properties")
    .addAsWebInfResource("jboss-ds.xml")
    .addAsResource("persistence.xml", "META-INF/persistence.xml")
    .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    return webArchive;
    }
     */
}
