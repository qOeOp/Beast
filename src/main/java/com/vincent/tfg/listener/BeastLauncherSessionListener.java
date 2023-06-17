package com.vincent.tfg.listener;

import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.LauncherSessionListener;
import org.springframework.stereotype.Component;

@Component
public class BeastLauncherSessionListener implements LauncherSessionListener {
    @Override
    public void launcherSessionOpened(LauncherSession session) {
        LauncherSessionListener.super.launcherSessionOpened(session);
    }
}
