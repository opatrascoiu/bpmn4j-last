package com.workflow.bpmn.model.metrics.finder;

import com.workflow.bpmn.model.VisitorContext;

import javax.xml.namespace.QName;
import java.util.Map;

//
// Finds only OtherAttributes - Map<QName, String>
//
public class OtherAttributesFinder extends Finder<Map<QName, String>> {
    @Override
    public boolean appliesTo(Object element, VisitorContext context) {
        return element instanceof Map && !((Map<?, ?>) element).isEmpty();
    }
}
