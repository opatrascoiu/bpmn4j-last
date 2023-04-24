package com.workflow.bpmn.model.metrics.counter;

import com.workflow.bpmn.model.VisitorContext;

import javax.xml.namespace.QName;
import java.util.Map;
import java.util.Set;

//
// Counts only OtherAttributes Map<QName, String>
//
public class OtherAttributesCounter extends Counter {
    @Override
    public void collect(Object element, VisitorContext context) {
        if (appliesTo(element, context)) {
            Set<Map.Entry<QName, String>> entries = ((Map<QName, String>) element).entrySet();
            for (Map.Entry<QName, String> entry: entries) {
                String key = entry.getKey().toString();
                this.counters.merge(key, 1, Integer::sum);
            }
        }
    }

    @Override
    public boolean appliesTo(Object element, VisitorContext context) {
        return element instanceof Map;
    }
}
