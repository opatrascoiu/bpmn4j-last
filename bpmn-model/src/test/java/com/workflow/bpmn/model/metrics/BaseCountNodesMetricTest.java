package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.AbstractTest;
import com.workflow.bpmn.model.metrics.counter.CountMetricResult;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public abstract class BaseCountNodesMetricTest extends AbstractTest {
    protected void doTest(Map<String, Integer> expected, String inputPath) {
        File inputFile = new File(resource(inputPath));
        CountMetricResult result = (CountMetricResult) getMetric().measure(List.of(inputFile));
        Assert.assertEquals(normalizeMap(expected), normalizeMap(result.getCounts()));
        assertEquals(normalizeList(new ArrayList<>(expected.keySet())), normalizeList(result.getNodeTypes()));
        assertEquals((long) expected.values().stream().reduce(0, Integer::sum), result.getTotalNodeCount());
    }

    private List<String> normalizeList(List<String> list) {
        if (list == null) {
            return null;
        }

        list.sort(String::compareTo);
        return list;
    }

    protected abstract Metric getMetric();
}