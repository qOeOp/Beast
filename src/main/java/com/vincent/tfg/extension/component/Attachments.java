package com.vincent.tfg.extension.component;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

public class Attachments extends ArrayList<Attachments.Entity> {
    @Getter
    @Setter
   public static class Entity{
        private Path path;
        private FileSuffix suffix;
        private String fileName;
        private String content;

        public void create() throws IOException {
            if (content != null && fileName != null && suffix != null && path != null) {
                Path resolved = path.resolve(suffix.getFileName(fileName));
                if (!resolved.toFile().exists()) {
                    File file = resolved.toFile();
                    if (suffix == FileSuffix.PNG) {
                        FileUtils.writeByteArrayToFile(file, content.getBytes());
                    } else if (suffix == FileSuffix.LOG) {
                        FileUtils.write(file, content, StandardCharsets.UTF_8);
                    }
                }
            }
        }
    }

    public static Entity buildEntity(){
        return new Entity();
    }
}
