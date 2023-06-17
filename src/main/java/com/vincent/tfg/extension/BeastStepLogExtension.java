package com.vincent.tfg.extension;

import com.vincent.tfg.extension.component.Attachments;
import com.vincent.tfg.extension.component.FileSuffix;
import com.vincent.tfg.extension.component.LogCutter;
import com.vincent.tfg.service.FileCreatorService;
import com.vincent.tfg.service.OutputCaptureService;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.List;

public class BeastStepLogExtension implements Extension, AfterEachCallback,OutputCaptureService, FileCreatorService {

    private static final String START = "===>";
    private static final String END = "<===";
    private static final String STEP = "STEP";

    // init attachment
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        capturedOutput(context).ifPresent(capturedOutput -> getPath(context).ifPresent(path -> getAttachments(context).ifPresent(attachments->{
            List<String> logPiece = LogCutter.cut(String.valueOf(capturedOutput), START, END);

            for (int i = 0; i < logPiece.size(); i++) {
                Attachments.Entity entity = Attachments.buildEntity();
                String fileName = String.format("%s%d", STEP, i + 1);
                entity.setPath(path);
                entity.setFileName(fileName);
                entity.setSuffix(FileSuffix.LOG);
                entity.setContent(logPiece.get(i));
                attachments.add(entity);
            }
        })));
    }
}
