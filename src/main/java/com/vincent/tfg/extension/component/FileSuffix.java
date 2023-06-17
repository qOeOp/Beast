package com.vincent.tfg.extension.component;

public enum FileSuffix {
    LOG(".log"), PNG(".png");

    private final String suffix;

    FileSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFileName(String name){
        return String.format("%s%s", name, suffix);
    }
}
