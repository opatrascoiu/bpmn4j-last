package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.metrics.counter.FlowElementCounter;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Map;

public class CountFlowElementsMetricTest extends BaseCountNodesMetricTest {
    @Override
    protected Metric getMetric() {
        return new CollectNodesMetric(new FlowElementCounter());
    }

    @Test
    public void testSimpleOrderProcess() {
        Map<String, Integer> expected = makeMap(
                Pair.of("TStartEvent", 1),
                Pair.of("TEndEvent", 1),
                Pair.of("TServiceTask", 4),
                Pair.of("TSequenceFlow", 5)
        );
        doTest(expected, "bpmn/input/simple-order.bpmn");
    }

    @Test
    public void testSimpleOrderProcessWithExceptions() {
        Map<String, Integer> expected = makeMap(
                Pair.of("TStartEvent", 1),
                Pair.of("TEndEvent", 2),
                Pair.of("TTask", 4),
                Pair.of("TExclusiveGateway", 2),
                Pair.of("TSequenceFlow", 9)
        );
        doTest(expected, "bpmn/input/simple-order-with-exceptions.bpmn");
    }

    @Test
    public void testSimpleOrderProcessInSwimLanes() {
        Map<String, Integer> expected = makeMap(
                Pair.of("TSubProcess", 1),
                Pair.of("TStartEvent", 2),
                Pair.of("TEndEvent", 4),
                Pair.of("TServiceTask", 2),
                Pair.of("TUserTask", 4),
                Pair.of("TExclusiveGateway", 3),
                Pair.of("TSequenceFlow", 15)
        );
        doTest(expected, "bpmn/input/simple-order-in-swimlanes.bpmn");
    }
}