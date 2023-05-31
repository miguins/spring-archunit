package br.com.archunit.poc.codecoverage;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.archunit.poc.codecoverage")
public class MyArchitectureTest {

    @ArchTest
    static final ArchRule should_verify_controller_class_are_in_controller_package = ArchRuleDefinition.classes().that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("..controller");

    @ArchTest
    static final Architectures.LayeredArchitecture should_verify_layers = layeredArchitecture().consideringAllDependencies()
            .layer("Controllers").definedBy("..controller")
            .layer("Services").definedBy("..service..")
            .layer("Repositories").definedBy("..repository..")
            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services");

//    @ArchTest
//    static final ArchRule should_verify_controller_class_only_access_class_from_service =
//            classes().that().haveSimpleNameEndingWith("Service")
//                    .should().onlyDependOnClassesThat().resideInAPackage("..controller");


}
