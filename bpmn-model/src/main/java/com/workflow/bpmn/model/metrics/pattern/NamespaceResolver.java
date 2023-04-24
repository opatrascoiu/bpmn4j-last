package com.workflow.bpmn.model.metrics.pattern;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

public class NamespaceResolver implements NamespaceContext {
    //Store the source document to search the namespaces
    private final Document sourceDocument;
 
    public NamespaceResolver(Document document) {
        this.sourceDocument = document;
    }
 
    //The lookup for the namespace uris is delegated to the stored document.
    @Override
    public String getNamespaceURI(String prefix) {
        if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
            return this.sourceDocument.lookupNamespaceURI(null);
        } else {
            return this.sourceDocument.lookupNamespaceURI(prefix);
        }
    }
 
    @Override
    public String getPrefix(String namespaceURI) {
        return this.sourceDocument.lookupPrefix(namespaceURI);
    }
 
    @Override
    public Iterator<String> getPrefixes(String namespaceURI) {
        return null;
    }
}