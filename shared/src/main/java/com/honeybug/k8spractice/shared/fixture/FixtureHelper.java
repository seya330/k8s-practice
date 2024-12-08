package com.honeybug.k8spractice.shared.fixture;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.*;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;

import java.util.List;

public class FixtureHelper {

    private static final FixtureMonkey fixtureMonkey;

    static {
        fixtureMonkey = FixtureMonkey.builder()
                .plugin(new JakartaValidationPlugin())
                .enableLoggingFail(false)
                .objectIntrospector(new FailoverIntrospector(
                        List.of(
                                FieldReflectionArbitraryIntrospector.INSTANCE,
                                ConstructorPropertiesArbitraryIntrospector.INSTANCE,
                                BuilderArbitraryIntrospector.INSTANCE
                        ), false))
                .build();
    }

    public static FixtureMonkey get() {
        return fixtureMonkey;
    }
}
