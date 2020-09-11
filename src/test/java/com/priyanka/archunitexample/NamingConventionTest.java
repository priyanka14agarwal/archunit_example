package com.priyanka.archunitexample;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;

@AnalyzeClasses(packages =("com.priyanka.archunitexample.namingConventions") , importOptions = ImportOption.DoNotIncludeTests.class)
public class NamingConventionTest {

    //checks if all the configuration class name ends with configuration
    @ArchTest
    public ArchRule configurationClassesShouldBeNamedConfiguration =
            ArchRuleDefinition.classes().that().areAnnotatedWith(Configuration.class)
                    .should().haveNameMatching(".*Configuration")
                    .because("We would like to have it consistent");

    //checks if all the classes containing word "controller" is under controller package
    @ArchTest
    public ArchRule classesWithNameControllerShouldBeOnlyInsideController =
            ArchRuleDefinition.classes().that().haveSimpleNameContaining("controller")
                .should().resideInAPackage("..controller..");
}
