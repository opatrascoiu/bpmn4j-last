package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.metrics.finder.Finder;
import com.workflow.bpmn.model.metrics.finder.MultiInstanceLoopCharacteristicsFinder;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.omg.spec.bpmn._20100524.model.TMultiInstanceLoopCharacteristics;

import java.util.Arrays;
import java.util.List;

public class FindMultiInstanceLoopCharacteristicsMetricTest extends BaseFindMetricTest<TMultiInstanceLoopCharacteristics> {
    @Override
    protected Finder<TMultiInstanceLoopCharacteristics> makeFinder() {
        return new MultiInstanceLoopCharacteristicsFinder();
    }

    @Override
    protected String toString(TMultiInstanceLoopCharacteristics right) {
        if (right == null) {
            return null;
        } else {
            return right.getCompletionCondition().getContent().toString();
        }
    }

    @Test
    public void testFindMultiInstanceLoop() {
        List<Pair<String, String>> expected = Arrays.asList(
                Pair.of("TDefinitions[id='Definitions_1672ulz']/TProcess[id='Process_1h4eu91']/TSubProcess[id='Activity_0peaf56']", "[${nrOfCompletedInstances == 1}]")
        );
        doTest(expected, "bpmn/input/pattern-1.bpmn");
    }
}