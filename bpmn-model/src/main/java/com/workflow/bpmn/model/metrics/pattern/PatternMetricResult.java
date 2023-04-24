package com.workflow.bpmn.model.metrics.pattern;

import com.workflow.bpmn.model.metrics.MetricResult;

import java.util.List;

public class PatternMetricResult implements MetricResult {
    private final List<BPMNReference> references;

    public PatternMetricResult(List<BPMNReference> references) {
        this.references = references;
    }

    public List<BPMNReference> getReferences() {
        return this.references;
    }
}
