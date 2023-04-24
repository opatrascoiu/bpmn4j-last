package com.workflow.bpmn.model.metrics.pattern;

import com.workflow.bpmn.model.AbstractTest;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class XPathPatternTest extends AbstractTest {
    private final XPathPattern patternMatcher = new XPathPattern();

    @Test
    public void testSubProcessMatcher() throws Exception {
        String modelPath = "bpmn/input/pattern-1.bpmn";
        String xPath = "//bpmn:subProcess";

        Map<String, String> expected = makeMap(
                Pair.of("id", "Activity_0peaf56")
        );
        doTest(expected, modelPath, xPath);
    }

    @Test
    public void testSubProcessMatcherById() throws Exception {
        String modelPath = "bpmn/input/pattern-1.bpmn";
        String xPath = "//bpmn:subProcess[@id='Activity_0peaf56']";

        Map<String, String> expected = makeMap(
                Pair.of("id", "Activity_0peaf56")
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

        Map<String, String> expected = makeMap(
                Pair.of("id", "Activity_0peaf56")
        );
        doTest(expected, modelPath, xPath);
    }

    private void doTest(Map<String, String> expected, String path, String xPathStatement) throws Exception {
        InputSource inputSource = new InputSource(resource(path).toString());
        NodeList nodeList = this.patternMatcher.match(inputSource, xPathStatement);

        assertEquals(expected, makeMap(nodeList));
    }

    private Map<String, String> makeMap(NodeList nodeList) {
        Map<String, String> map = new LinkedHashMap<>();
        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String key = "id";
            Node namedItem = node.getAttributes().getNamedItem(key);
            if (namedItem != null) {
                map.put(key, namedItem.getNodeValue());
            }
        }
        return map;
    }
}
