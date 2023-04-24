package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.VisitorContext;

public interface MetricCollector<R> {
    boolean appliesTo(Object element, VisitorContext context);
    void collect(Object element, VisitorContext context);
    R getResult();
}
