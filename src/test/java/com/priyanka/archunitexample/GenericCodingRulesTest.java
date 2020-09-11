package com.priyanka.archunitexample;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

@AnalyzeClasses(packages = "com.priyanka.archunitexample.generalCodingRules", importOptions = ImportOption.DoNotIncludeTests.class)
public class GenericCodingRulesTest {
    //all generic coding rules can be accessed via com.tngtech.archunit.library.GeneralCodingRules

    @ArchTest
    ArchRule classesShouldNotThrowGenericExceptions =
            GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

    @ArchTest
    ArchRule classesShouldNotUseStandardStreams =
            GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

}
