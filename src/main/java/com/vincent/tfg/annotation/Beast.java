package com.vincent.tfg.annotation;

import com.vincent.tfg.extension.BeastExtension;
import com.vincent.tfg.extension.BeastStepLogExtension;
import com.vincent.tfg.extension.FileCreatorExtension;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({BeastExtension.class, FileCreatorExtension.class})
public @interface Beast {
}
