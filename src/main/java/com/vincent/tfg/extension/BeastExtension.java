package com.vincent.tfg.extension;

import com.vincent.tfg.service.OutputCaptureService;
import com.vincent.tfg.context.BeastContext;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.util.ClassUtils;

import java.util.Optional;

public class BeastExtension implements Extension, BeforeEachCallback, AfterEachCallback, BeforeAllCallback,
        AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, TestWatcher, TestInstanceFactory,
        TestInstancePreConstructCallback, TestInstancePostProcessor, TestInstancePreDestroyCallback, OutputCaptureService,
        ParameterResolver {
    protected OutputCaptureExtension outputCaptureExtension = BeanUtils.instantiateClass(OutputCaptureExtension.class);

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // delegate log recorder
        outputCaptureExtension.afterEach(context);
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // delegate log recorder
        outputCaptureExtension.beforeEach(context);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {

    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return ClassUtils.isAssignable(parameterContext.getParameter().getType(), BeastContext.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        CapturedOutput capturedOutput = (CapturedOutput) outputCaptureExtension.resolveParameter(parameterContext, extensionContext);
        BeastContext beastContext = new BeastContext();
        beastContext.setCapturedOutput(capturedOutput);
        return beastContext;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {

    }

    @Override
    public Object createTestInstance(TestInstanceFactoryContext factoryContext, ExtensionContext extensionContext) throws TestInstantiationException {
        return BeanUtils.instantiateClass(factoryContext.getTestClass());
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {

    }

    @Override
    public void preConstructTestInstance(TestInstanceFactoryContext factoryContext, ExtensionContext context) throws Exception {

    }

    @Override
    public void preDestroyTestInstance(ExtensionContext context) throws Exception {

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
    }
}
