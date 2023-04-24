package com.workflow.bpmn.model.metrics.counter;

import com.workflow.bpmn.model.VisitorContext;

import java.util.Map;

public class NodeCounter extends Counter {
    @Override
    public boolean appliesTo(Object element, VisitorContext context) {
        return element != null && !(element instanceof Map);
    }
}
