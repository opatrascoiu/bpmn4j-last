package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.error.BPMNSemanticError;
import com.workflow.bpmn.model.metrics.pattern.BPMNReference;
import com.workflow.bpmn.model.metrics.pattern.PatternMetricResult;
import com.workflow.bpmn.model.metrics.pattern.XPathPattern;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MatchNodesMetric extends SimpleMetric<PatternMetricResult> {
    private final XPathPattern xPathPattern = new XPathPattern();
    private final String xPath;

    public MatchNodesMetric(String xPath) {
        super("Match Nodes");
        this.xPath = xPath;
    }

    @Override
    public PatternMetricResult measure(List<File> files) {
        List<BPMNReference> references = new ArrayList<>();
        for (File file: files) {
            try {
                URI modelLocationURI = file.toURI();
                FileInputStream inputStream = new FileInputStream(file);
                InputSource inputSource = new InputSource(inputStream);
                Document doc = this.xPathPattern.makeDocument(inputSource);
                NodeList match = this.xPathPattern.match(doc, this.xPath);
                List<BPMNReference> localReferences = toReferences(modelLocationURI, doc, match);
                references.addAll(localReferences);
            } catch (Exception e) {
                throw new BPMNSemanticError(String.format("Cannot process input '%s'", file.getPath()), e);
            }
        }
        return new PatternMetricResult(references);
    }

    private List<BPMNReference> toReferences(URI modelLocationURI, Document doc, NodeList nodeList) {
        List<BPMNReference> references = new ArrayList<>();
        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String key = "id";
            Node namedItem = node.getAttributes().getNamedItem(key);
            if (namedItem != null) {
                references.add(toReference(modelLocationURI, doc, node));
            }
        }
        return references;
    }

    private BPMNReference toReference(URI modelLocationURI, Document doc, Node node) {
        String modelName = getId(doc.getFirstChild());
        String qName = node.getNodeName();
        String id = getId(node);
        return new BPMNReference(modelLocationURI, modelName, qName, id);
    }

    private String getId(Node node) {
        Node idNode = node.getAttributes().getNamedItem("id");
        return idNode == null ? "" : idNode.getNodeValue();
    }
}
