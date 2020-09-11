package com.priyanka.archunitexample;

import com.priyanka.archunitexample.customAnnotation.MyAnnotation;
import com.priyanka.archunitexample.customAnnotation.Secured;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.priyanka.archunitexample.customAnnotation", importOptions = ImportOption.DoNotIncludeTests.class)
public class CustomRulesTest {

    DescribedPredicate<JavaClass> haveAFieldAnnotatedWithMyAnnotation =
            new DescribedPredicate<JavaClass>("have a field annotated with @MyAnnotation"){
                @Override
                public boolean apply(JavaClass input) {
                    return input.getFields().stream().anyMatch(f-> f.isAnnotatedWith(MyAnnotation.class));
                }
            };

    ArchCondition<JavaClass> onlyBeAccessedBySecuredMethods =
            new ArchCondition<JavaClass>("only be accessed by @Secured methods") {
                @Override
                public void check(JavaClass item, ConditionEvents events) {
                    for (JavaMethod call : item.getMethods()) {
                        System.out.println("call is ---"+ call.getFullName());
                        if (!call.isAnnotatedWith(Secured.class)) {
                            String message = String.format(
                                    "Method %s is not @Secured", call.getFullName());
                            events.add(SimpleConditionEvent.violated(call, message));
                        }
                    }
                }
            };


    @ArchTest
    public ArchRule rule = ArchRuleDefinition.classes()
            .that(haveAFieldAnnotatedWithMyAnnotation)
            .should(onlyBeAccessedBySecuredMethods);
}
