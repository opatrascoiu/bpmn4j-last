package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.metrics.counter.NodeCounter;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Map;

public class CountNodesMetricTest extends BaseCountNodesMetricTest {
    @Override
    protected Metric getMetric() {
        return new CollectNodesMetric(new NodeCounter());
    }

    @Test
    public void testSimpleOrderProcess() {
        Map<String, Integer> expected = makeMap(
                Pair.of("BPMNDiagram", 1),
                Pair.of("BPMNEdge", 5),
                Pair.of("BPMNLabel", 2),
                Pair.of("BPMNPlane", 1),
                Pair.of("BPMNShape", 6),
                Pair.of("Bounds", 8),
                Pair.of("Point", 10),
                Pair.of("TProcess", 1),
                Pair.of("TStartEvent", 1),
                Pair.of("TEndEvent", 1),
                Pair.of("TServiceTask", 4),
                Pair.of("TSequenceFlow", 5),
                Pair.of("TExtensionElements", 4)
        );
        doTest(expected, "bpmn/input/simple-order.bpmn");
    }

    @Test
    public void testSimpleOrderProcessWithExceptions() {
        Map<String, Integer> expected = makeMap(
                Pair.of("BPMNDiagram", 1),
                Pair.of("BPMNEdge", 9),
                Pair.of("BPMNLabel", 8),
                Pair.of("BPMNPlane", 1),
                Pair.of("BPMNShape", 9),
                Pair.of("Bounds", 17),
                Pair.of("Point", 20),
                Pair.of("TProcess", 1),
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
                Pair.of("BPMNDiagram", 1),
                Pair.of("BPMNEdge", 15),
                Pair.of("BPMNLabel", 13),
                Pair.of("BPMNPlane", 1),
                Pair.of("BPMNShape", 20),
                Pair.of("Bounds", 33),
                Pair.of("Point", 40),
                Pair.of("TCollaboration", 1),
                Pair.of("TParticipant", 1),
                Pair.of("TProcess", 1),
                Pair.of("TLaneSet", 1),
                Pair.of("TLane", 3),
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