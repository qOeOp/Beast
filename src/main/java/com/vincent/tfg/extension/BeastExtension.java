package com.vincent.tfg.extension;

import org.junit.jupiter.api.extension.*;
import org.springframework.util.ClassUtils;

import java.util.Objects;

public class BeastExtension implements Extension, AfterEachCallback, BeforeAllCallback, BeforeEachCallback,BeforeTestExecutionCallback,ParameterResolver {

    String placeholder;
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println();
    }

    @Override
    public String toString() {
        return "BoosterExtension{" +
                "placeholder='" + placeholder + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeastExtension that)) return false;
        return Objects.equals(placeholder, that.placeholder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeholder);
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        String uniqueId = context.getUniqueId();
        System.out.println();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Class<?> requiredTestClass = context.getRequiredTestClass();
        System.out.println(this);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println(3);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return ClassUtils.isAssignable(parameterContext.getParameter().getType(), BeastExtension.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.out.println(2);
        return null;
    }
}
