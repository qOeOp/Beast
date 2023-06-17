package com.vincent.tfg.listener;

import com.vincent.tfg.annotation.JiraEntry;
import com.vincent.tfg.annotation.OnlyMe;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.launcher.PostDiscoveryFilter;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Predicate;



public class BeastTestDiscoveryFilter implements PostDiscoveryFilter {
    @Override
    public FilterResult apply(TestDescriptor object) {
        if (ClassUtils.isAssignableValue(MethodBasedTestDescriptor.class,object)) {
            boolean onlyMe = false;
            Optional<TestDescriptor> parent = object.getParent();
            while (parent.isPresent()&& parent.get().isContainer())
            {
                Optional<TestSource> source = parent.get().getSource();
                if (source.isPresent()&&AnnotationUtils.findAnnotation(((ClassSource) source.get()).getJavaClass(), OnlyMe.class).isPresent()) {
                    onlyMe = true;
                    break;
                }
                parent = parent.get().getParent();
            }
            Method testMethod = ((TestMethodTestDescriptor) object).getTestMethod();
            if (onlyMe) {
                return AnnotationUtils.findAnnotation(testMethod, JiraEntry.class).isPresent() ? FilterResult.includedIf(true) : FilterResult.includedIf(false);
            }
        }
        return FilterResult.includedIf(true);
    }

    @Override
    public Predicate<TestDescriptor> toPredicate() {
        return PostDiscoveryFilter.super.toPredicate();
    }


}
