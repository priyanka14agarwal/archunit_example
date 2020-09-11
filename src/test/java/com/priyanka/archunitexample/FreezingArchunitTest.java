package com.priyanka.archunitexample;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

/*
Freezing archRule is used in scenario when a project is under development and we want to ignore few architectural
rules. Or if we intentionally make some architectural exceptions and want archunit to ignore those code fragments.
By freezing, it stores the rules and classes breaking the rule in a seperate archunit_store(present at root of project)
and do not fail the test.
 */
@AnalyzeClasses(packages = "com.priyanka.archunitexample.generalCodingRules", importOptions = ImportOption.DoNotIncludeTests.class)
public class FreezingArchunitTest {

    @ArchTest
    ArchRule classesShouldNotThrowGenericExceptions =
            freeze(GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS);

}
