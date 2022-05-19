package com.woowa.cleanarchitecture.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class ApplicationLayer extends ArchitectureElement {
    private final HexagonalArchitecture parentContext;
    private List<String> incomingPortPackages = new ArrayList<>();
    private List<String> outgoingPortPackages = new ArrayList<>();
    private List<String> servicePackages = new ArrayList<>();

    public ApplicationLayer(String basePackage, HexagonalArchitecture parentContext) {
        super(basePackage);
        this.parentContext = parentContext;
    }

    public ApplicationLayer incomingPorts(String packageName) {
        incomingPortPackages.add(fullQualifiedPackage(packageName));
        return this;
    }

    public ApplicationLayer outgoingPorts(String packageName) {
        outgoingPortPackages.add(fullQualifiedPackage(packageName));
        return this;
    }

    public ApplicationLayer services(String packageName) {
        servicePackages.add(fullQualifiedPackage(packageName));
        return this;
    }

    public HexagonalArchitecture and() {
        return parentContext;
    }

    public void doesNotDependOn(String packageName, JavaClasses classes) {
        denyDependency(basePackage, packageName, classes);
    }

    public void incomingAndOutgoingPortsDoNotDependOnEachOther(JavaClasses classes) {
        denyAnyDependency(incomingPortPackages, outgoingPortPackages, classes);
        denyAnyDependency(outgoingPortPackages, incomingPortPackages, classes);
    }

    private List<String> allPackages() {
        List<String> allPackages = new ArrayList<>();
        allPackages.addAll(incomingPortPackages);
        allPackages.addAll(outgoingPortPackages);
        allPackages.addAll(servicePackages);
        return allPackages;
    }

    void doesNotContainEmptyPackages() {
        denyEmptyPackages(allPackages());
    }
}
