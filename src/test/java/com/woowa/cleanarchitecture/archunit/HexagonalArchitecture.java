package com.woowa.cleanarchitecture.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HexagonalArchitecture extends ArchitectureElement {
    private Adapters adapters;
    private ApplicationLayer applicationLayer;
    private String configurationPackage;
    private List<String> domainPackages = new ArrayList<>();

    public HexagonalArchitecture(String basePackage) {
        super(basePackage);
    }

    public static HexagonalArchitecture boundedContext(String basePackage) {
        return new HexagonalArchitecture(basePackage);
    }

    public HexagonalArchitecture withDomainLayer(String domainPackage) {
        domainPackages.add(fullQualifiedPackage(domainPackage));
        return this;
    }

    public HexagonalArchitecture withConfiguration(String packageName) {
        this.configurationPackage = fullQualifiedPackage(packageName);
        return this;
    }

    public Adapters withAdapterLayer(String adapterPackage) {
        adapters = new Adapters(this, fullQualifiedPackage(adapterPackage));
        return adapters;
    }

    public ApplicationLayer withApplicationLayer(String applicationPackage) {
        this.applicationLayer = new ApplicationLayer(fullQualifiedPackage(applicationPackage), this);
        return this.applicationLayer;
    }

    public void check(JavaClasses classes) {
        adapters.doesNotContainEmptyPackages();
        adapters.dontDependOnEachOther(classes);
        adapters.doesNotDependOn(configurationPackage, classes);
        applicationLayer.doesNotContainEmptyPackages();
        applicationLayer.doesNotDependOn(adapters.getBasePackage(), classes);
        applicationLayer.doesNotDependOn(configurationPackage, classes);
        applicationLayer.incomingAndOutgoingPortsDoNotDependOnEachOther(classes);
        domainDoestNotDependOnOtherPackages(classes);
    }

    private void domainDoestNotDependOnOtherPackages(JavaClasses classes) {
        denyAnyDependency(domainPackages, Collections.singletonList(adapters.basePackage), classes);
        denyAnyDependency(domainPackages, Collections.singletonList(applicationLayer.basePackage), classes);
    }
}
