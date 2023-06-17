package com.vincent.tfg.listener;

import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class BeastListener implements TestExecutionListener {
    /**
     * context id -> step1:
     *            -> step2:
     *
     * */
    Logger log = getLogger(BeastListener.class);
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        TestExecutionListener.super.testPlanExecutionStarted(testPlan);

        List<TestIdentifier> collect = testPlan.getRoots().stream().flatMap(p -> testPlan.getDescendants(p).stream()).collect(Collectors.toList());
        for (TestIdentifier testIdentifier : collect) {
            if (testIdentifier.isTest()) {
                UniqueId uniqueId = testIdentifier.getUniqueIdObject();
                List<UniqueId.Segment> segments = testIdentifier.getUniqueIdObject().getSegments();
                for (int i = 1; i < segments.size(); i++) {
                    if (segments.get(i).getType().equals("suite")) {
                        for (int j = 1; j < segments.size() - i; j++) {
                            uniqueId = uniqueId.removeLastSegment();
                        }
                        System.out.println(uniqueId);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
        TestExecutionListener.super.reportingEntryPublished(testIdentifier, entry);
        log.info(entry.toString());
    }
}
