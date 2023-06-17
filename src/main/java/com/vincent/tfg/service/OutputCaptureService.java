package com.vincent.tfg.service;

import lombok.NonNull;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.util.ClassUtils;

import java.util.Optional;

public interface OutputCaptureService {

    ExtensionContext.Namespace namespace = ExtensionContext.Namespace.create(OutputCaptureExtension.class);

    default Optional<CapturedOutput> capturedOutput(@NonNull OutputCaptureExtension outputCaptureExtension, @NonNull ExtensionContext context) {
        CapturedOutput capturedOutput = (CapturedOutput) outputCaptureExtension.resolveParameter(null, context);
        return capturedOutput==null?Optional.empty():Optional.of(capturedOutput);
    }

    default Optional<CapturedOutput> capturedOutput(@NonNull ExtensionContext context){
        try {
            Class<?> x = ClassUtils.forName("org.springframework.boot.test.system.OutputCapture", ClassUtils.getDefaultClassLoader());
            ExtensionContext.Store store = context.getStore(namespace);
            CapturedOutput capturedOutput = (CapturedOutput) store.get(x);
            return capturedOutput==null?Optional.empty():Optional.of(capturedOutput);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
