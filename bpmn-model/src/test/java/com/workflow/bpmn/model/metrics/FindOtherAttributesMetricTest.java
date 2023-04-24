package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.metrics.finder.Finder;
import com.workflow.bpmn.model.metrics.finder.OtherAttributesFinder;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindOtherAttributesMetricTest extends BaseFindMetricTest<Map<QName, String>> {
    @Override
    protected Finder<Map<QName, String>> makeFinder() {
        return new OtherAttributesFinder();
    }

    @Override
    protected String toString(Map<QName, String> right) {
        if (right == null) {
            return null;
        } else {
            return right.toString();
        }
    }


    @Test
    public void testCountingOtherAttributes() {
        List<Pair<String, String>> expected = Arrays.asList(
                Pair.of(
                        "TDefinitions[id='Definitions_1672ulz']/TProcess[id='Process_1h4eu91']/TSubProcess[id='Activity_0peaf56']/TMultiInstanceLoopCharacteristics",
                        "{{http://workflow.ep.gs.com/bpmn}displayLabel=#{assignee}, {http://activiti.org/bpmn}elementVariable=assignee, {http://activiti.org/bpmn}collection=${payload.assignees}}"
                )
        );
        doTest(expected, "bpmn/input/pattern-1.bpmn");
    }

    @Test
    public void testSimpleOrderProcess() {
        List<Pair<String, String>> expected = new ArrayList<>();
        doTest(expected, "bpmn/input/simple-order.bpmn");
    }
}