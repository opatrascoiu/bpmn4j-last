package com.workflow.bpmn.model.metrics.pattern;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XPathPattern {
    public Document makeDocument(InputSource inputSource) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.parse(inputSource);
        this.clean(doc);
        return doc;
    }

    public NodeList match(InputSource inputSource, String xPathStatement) throws Exception {
        Document doc = makeDocument(inputSource);
        return match(doc, xPathStatement);
    }

    public NodeList match(Document doc, String xPathStatement) throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        xPath.setNamespaceContext(new NamespaceResolver(doc));
        XPathExpression expr = xPath.compile(xPathStatement);

        return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    }

    private void clean(Node node) {
        NodeList children = node.getChildNodes();
        for (int n = children.getLength() - 1; n >= 0; n--) {
            Node child = children.item(n);
            short nodeType = child.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {
                clean(child);
            } else if (nodeType == Node.TEXT_NODE) {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0){
                    node.removeChild(child);
                }
                else {
                    child.setNodeValue(trimmedNodeVal);
                }
            } else if (nodeType == Node.COMMENT_NODE) {
                node.removeChild(child);
            }
        }
    }
}
