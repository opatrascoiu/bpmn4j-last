package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.metrics.counter.OtherAttributesCounter;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOtherAttributesMetricTest extends BaseCountNodesMetricTest {
    @Override
    protected Metric getMetric() {
        return new CollectNodesMetric(new OtherAttributesCounter());
    }

    @Test
    public void testCountingOtherAttributes() {
        Map<String, Integer> expected = makeMap(
                Pair.of("{http://activiti.org/bpmn}collection", 1),
                Pair.of("{http://activiti.org/bpmn}elementVariable", 1),
                Pair.of("{http://workflow.ep.gs.com/bpmn}displayLabel", 1)
        );
        doTest(expected, "bpmn/input/pattern-1.bpmn");
    }

    @Test
    public void testSimpleOrderProcess() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        doTest(expected, "bpmn/input/simple-order.bpmn");
    }
}