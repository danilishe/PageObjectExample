package org.example.hooks;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import org.example.Expression;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class CucumberConfig implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "exp",
                "\"([^\"]+)\"",
                Expression.class,
                Expression::new)
        );
    }
}
