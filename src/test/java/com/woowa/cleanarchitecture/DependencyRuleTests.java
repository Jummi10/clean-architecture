package com.woowa.cleanarchitecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.woowa.cleanarchitecture.archunit.HexagonalArchitecture;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class DependencyRuleTests {
    @Test
    void domainLayerDoesNotDependOnApplicationLayer() {
        noClasses()
                .that()
                .resideInAPackage("com.woowa.cleanarchitecture.account.domain..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("com.woowa.cleanarchitecture.account.application..")
                .check(new ClassFileImporter()
                        .importPackages("com.woowa.cleanarchitecture.account.."));
    }

    @Test
    void validateRegistrationContextArchitecture() {
        HexagonalArchitecture.boundedContext("com.woowa.cleanarchitecture.account")
                .withDomainLayer("domain")

                .withAdapterLayer("adapter")
                .incoming("in.web")
                .outgoing("out.persistence")
                .and()

                .withApplicationLayer("application")
                .services("service")
                .incomingPorts("port.in")
                .outgoingPorts("port.out")
                .and()

                .withConfiguration("configuration")
                .check(new ClassFileImporter()
                        .importPackages("com.woowa.cleanarchitecture.."));
    }
}
