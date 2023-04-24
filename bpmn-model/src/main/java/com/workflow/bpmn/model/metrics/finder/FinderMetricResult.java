package com.workflow.bpmn.model.metrics.finder;

import com.workflow.bpmn.model.metrics.MetricResult;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class FinderMetricResult<T> implements MetricResult {
    private final List<Pair<String, T>> results;

    public FinderMetricResult(List<Pair<String, T>> results) {
        this.results = results;
    }

    public List<Pair<String, T>> getResults() {
        return results;
    }
}