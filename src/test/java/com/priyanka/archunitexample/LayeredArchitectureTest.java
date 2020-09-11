package com.priyanka.archunitexample;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.priyanka.archunitexample.layeredArchitecture", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    //checks if a layered architecture is followed. That is controller should access service and not vice-versa.
    @ArchTest
    public ArchRule layerAccessibilityCheck= Architectures.layeredArchitecture()
            .layer("controller").definedBy("..controller..")
            .layer("service").definedBy("..services..")
            .whereLayer("controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("service").mayOnlyBeAccessedByLayers("controller");

    @ArchTest
    ArchRule dependencyCheck = ArchRuleDefinition.classes()
            .that().resideInAPackage("..service..")
            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");
}
