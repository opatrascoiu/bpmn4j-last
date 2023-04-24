package com.workflow.bpmn.model.metrics.counter;

import com.workflow.bpmn.model.VisitorContext;
import org.omg.spec.bpmn._20100524.model.TFlowNode;

//
// Counts only TFlowNodes
//
public class FlowNodeCounter extends Counter {
    @Override
    public boolean appliesTo(Object element, VisitorContext context) {
        return element instanceof TFlowNode;
    }
}
