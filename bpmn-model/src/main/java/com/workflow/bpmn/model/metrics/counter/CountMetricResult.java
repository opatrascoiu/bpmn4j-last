package com.workflow.bpmn.model.metrics.counter;

import com.workflow.bpmn.model.metrics.MetricResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountMetricResult implements MetricResult {
    private final Map<String, Integer> counters;

    public CountMetricResult(Map<String, Integer> counters) {
        this.counters = counters;
    }

    public Map<String, Integer> getCounts() {
        return this.counters;
    }

    public List<String> getNodeTypes() {
        return new ArrayList<>(this.counters.keySet());
    }

    public long getTotalNodeCount() {
        return this.counters.values().stream().reduce(0, Integer::sum);
    }
}
