package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.AbstractTest;
import com.workflow.bpmn.model.metrics.pattern.BPMNReference;
import com.workflow.bpmn.model.metrics.pattern.PatternMetricResult;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MatchNodesMetricTest extends AbstractTest {
    @Test
    public void testSubProcessMatch() throws Exception {
        String modelPath = "bpmn/input/pattern-1.bpmn";
        String xPath = "//bpmn:subProcess";

        URI modelLocationURI = resource(modelPath).toURL().toURI();
        List<BPMNReference> expected = List.of(
                new BPMNReference(modelLocationURI, "Definitions_1672ulz", "bpmn:subProcess", "Activity_0peaf56")
        );
        doTest(expected, modelPath, xPath);
    }

    @Test
    public void testSubProcessMatcherById() throws Exception {
        String modelPath = "bpmn/input/pattern-1.bpmn";
        String xPath = "//bpmn:subProcess[@id='Activity_0peaf56']";

        URI modelLocationURI = resource(modelPath).toURL().toURI();
        List<BPMNReference> expected = List.of(
                new BPMNReference(modelLocationURI, "Definitions_1672ulz", "bpmn:subProcess", "Activity_0peaf56")
        );
        doTest(expected, modelPath, xPath);
    }

    @Test
    public void testSubProcessMatcherByCompletionCondition() throws Exception {
        String modelPath = "bpmn/input/pattern-1.bpmn";
//        String xPath = "//bpmn:subProcess" +
//                "[" +
//                    "bpmn:multiInstanceLoopCharacteristics" +
//                    "/bpmn:completionCondition[" +
//                        "contains(normalize-space(text()), \"${nrOfCompletedInstances == 1}\")" +
//                    "]" +
//                "]";
        String xPath = "//bpmn:subProcess" +
                "[" +
                    "bpmn:multiInstanceLoopCharacteristics" +
                    "/bpmn:completionCondition[" +
                        "contains(text(), \"nrOfCompletedInstances\")" +
                    "]" +
                "]";

        URI modelLocationURI = resource(modelPath).toURL().toURI();
        List<BPMNReference> expected = List.of(
                new BPMNReference(modelLocationURI, "Definitions_1672ulz", "bpmn:subProcess", "Activity_0peaf56")
        );
        doTest(expected, modelPath, xPath);
    }

    private void doTest(List<BPMNReference> expected, String path, String xPath) {
        File inputFile = new File(resource(path));
        MatchNodesMetric metric = new MatchNodesMetric(xPath);
        PatternMetricResult result = (PatternMetricResult) metric.measure(List.of(inputFile));
        List<BPMNReference> references = result.getReferences();
        assertEquals(expected, references);
    }
}
