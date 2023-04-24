package com.workflow.bpmn.model.metrics.counter;

import com.workflow.bpmn.model.VisitorContext;
import com.workflow.bpmn.model.metrics.MetricCollector;
import com.workflow.bpmn.model.metrics.MetricResult;
import org.apache.commons.lang3.StringUtils;
import org.omg.spec.bpmn._20100524.model.TBoundaryEvent;
import org.omg.spec.bpmn._20100524.model.TCatchEvent;
import org.omg.spec.bpmn._20100524.model.TEventDefinition;
import org.omg.spec.bpmn._20100524.model.TThrowEvent;

import javax.xml.bind.JAXBElement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//
// Counts all BPMN elements
//
public abstract class Counter implements MetricCollector<MetricResult> {
    protected final Map<String, Integer> counters = new LinkedHashMap<>();

    @Override
    public void collect(Object element, VisitorContext context) {
        if (appliesTo(element, context)) {
            String key = makeKey(element);
            this.counters.merge(key, 1, Integer::sum);
        }
    }

    @Override
    public abstract boolean appliesTo(Object element, VisitorContext context);

    protected String makeKey(Object element) {
        Objects.requireNonNull(element, "BPMN element cannot be null");
        String key = element.getClass().getSimpleName();
        if (element instanceof TCatchEvent) {
            // Add event type
            String suffix = makeEventKey(((TCatchEvent) element).getEventDefinition());
            if (!StringUtils.isBlank(suffix)) {
                key = String.format("%s.%s", key, suffix);
            }
            // Add parallel flag
            boolean parallelMultiple = ((TCatchEvent) element).isParallelMultiple();
            if (parallelMultiple) {
                key = String.format("%s.parallelMultiple", key);
            }
            // Add cancel flag
            if (element instanceof TBoundaryEvent) {
                boolean cancelActivity = ((TBoundaryEvent) element).isCancelActivity();
                if (cancelActivity) {
                    key = String.format("%s.cancelActivity", key);
                }
            }
        } else if (element instanceof TThrowEvent) {
            // Add event type
            String suffix = makeEventKey(((TThrowEvent) element).getEventDefinition());
            if (!StringUtils.isBlank(suffix)) {
                key = String.format("%s.%s", key, suffix);
            }
        }
        return key;
    }

    private String makeEventKey(List<JAXBElement<? extends TEventDefinition>> eventDefinition) {
        if (eventDefinition == null || eventDefinition.isEmpty()) {
            return null;
        }
        if (eventDefinition.size() > 1) {
            throw new RuntimeException("Too many event definitions. Expected one");
        }

        return eventDefinition.get(0).getValue().getClass().getSimpleName();
    }

    @Override
    public MetricResult getResult() {
        return new CountMetricResult(this.counters);
    }
}
