package com.vincent.tfg.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.test.system.CapturedOutput;

@Getter
@Setter
public class BeastContext {
    private CapturedOutput capturedOutput;
}
