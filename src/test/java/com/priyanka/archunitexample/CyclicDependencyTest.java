package com.priyanka.archunitexample;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "com.priyanka.archunitexample.cyclicDependency", importOptions = ImportOption.DoNotIncludeTests.class)
public class CyclicDependencyTest {

    @ArchTest
    ArchRule checkForCyclicDependency =
            SlicesRuleDefinition.slices().matching("..(services).(*)..")
            .should().beFreeOfCycles();

}
