package com.workflow.bpmn.model.metrics.pattern;

import java.net.URI;
import java.util.Objects;

public class BPMNReference {
    private final URI modelLocationURI;
    private final String modelId;
    private final String qName;
    private final String elementId;

    public BPMNReference(URI modelLocationURI, String modelId, String qName, String elementId) {
        this.modelLocationURI = modelLocationURI;
        this.modelId = modelId;
        this.qName = qName;
        this.elementId = elementId;
    }

    public URI getModelLocationURI() {
        return modelLocationURI;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getQName() {
        return this.qName;
    }

    public String getElementId() {
        return this.elementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BPMNReference that = (BPMNReference) o;
        return Objects.equals(this.modelId, that.modelId) && Objects.equals(this.qName, that.qName) && Objects.equals(this.elementId, that.elementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.modelId, this.qName, this.elementId);
    }

    @Override
    public String toString() {
        return String.format("Reference(model='%s', qName='%s', id='%s')", this.modelId, this.qName, this.elementId);
    }
}
