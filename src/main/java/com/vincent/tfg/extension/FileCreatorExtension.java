package com.vincent.tfg.extension;

import com.vincent.tfg.extension.component.Attachments;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.extension.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

/**
 * Auto create folder and register path to all {@link com.vincent.tfg.extension.component.Attachments Attachments}
 *
 * @author Vincent
 * @see BeastStepLogExtension
 * @since 0.0.1
 */
public class FileCreatorExtension implements Extension, AfterAllCallback, BeforeAllCallback, BeforeEachCallback {

    private static final Path temp= Path.of(FileUtils.getTempDirectoryPath()).resolve(DateFormatUtils.format(new Date(),String.format("dd-MM-yyyy HH%smm%1$sss","\u02D0")));

    // scan all attachments and create
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(getClass()));
        Attachments attachments = store.get(Attachments.class,Attachments.class);
        for (Attachments.Entity attachment : attachments) {
            attachment.create();
        }

    }

    // create folder for class, put attachments instance under store
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(getClass()));
        store.getOrComputeIfAbsent(Path.class, (key) -> temp.resolve(context.getRequiredTestClass().getCanonicalName()),
                Path.class);
        store.getOrComputeIfAbsent(Attachments.class, (key) -> new Attachments(), Attachments.class);
    }

    // create folder for method
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(getClass()));
        Path path = store.get(Path.class, Path.class);
        store.put(Path.class, path.resolve(context.getRequiredTestMethod().getName()));
    }
}
