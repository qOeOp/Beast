package com.vincent.tfg.service;

import com.vincent.tfg.extension.FileCreatorExtension;
import com.vincent.tfg.extension.component.Attachments;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.nio.file.Path;
import java.util.Optional;

public interface FileCreatorService {
    default Optional<Path> getPath(ExtensionContext context){
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(FileCreatorExtension.class));
        Path path = store.get(Path.class, Path.class);
        return path==null?Optional.empty():Optional.of(path);
    }

    default Optional<Attachments> getAttachments(ExtensionContext context){
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(FileCreatorExtension.class));
        Attachments attachments = store.get(Attachments.class, Attachments.class);
        return attachments==null?Optional.empty():Optional.of(attachments);
    }
}
