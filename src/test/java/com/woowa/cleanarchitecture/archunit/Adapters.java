package com.woowa.cleanarchitecture.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class Adapters extends ArchitectureElement {
    private final HexagonalArchitecture parentContext;
    private List<String> incomingAdapterPackages = new ArrayList<>();
    private List<String> outgoingAdapterPackages = new ArrayList<>();

    public Adapters(HexagonalArchitecture parentContext, String basePackage) {
        super(basePackage);
        this.parentContext = parentContext;
    }

    public Adapters outgoing(String packageName) {
        outgoingAdapterPackages.add(fullQualifiedPackage(packageName));
        return this;
    }

    public Adapters incoming(String packageName) {
        incomingAdapterPackages.add(fullQualifiedPackage(packageName));
        return this;
    }

    public HexagonalArchitecture and() {
        return parentContext;
    }

    void dontDependOnEachOther(JavaClasses classes) {
        List<String> allAdapters = allAdapterPackages();
        for (String adapter1 : allAdapters) {
            for (String adapter2 : allAdapters) {
                if (!adapter1.equals(adapter2)) {
                    denyDependency(adapter1, adapter2, classes);
                }
            }
        }
    }

    List<String> allAdapterPackages() {
        List<String> allAdapters = new ArrayList<>();
        allAdapters.addAll(incomingAdapterPackages);
        allAdapters.addAll(outgoingAdapterPackages);
        return allAdapters;
    }

    void doesNotDependOn(String packageName, JavaClasses classes) {
        denyDependency(basePackage, packageName, classes);
    }

    void doesNotContainEmptyPackages() {
        denyEmptyPackages(allAdapterPackages());
    }

    String getBasePackage() {
        return basePackage;
    }
}
