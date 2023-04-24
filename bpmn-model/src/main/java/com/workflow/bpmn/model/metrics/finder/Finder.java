package com.workflow.bpmn.model.metrics.finder;

import com.workflow.bpmn.model.VisitorContext;
import com.workflow.bpmn.model.metrics.MetricCollector;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class Finder<T> implements MetricCollector<FinderMetricResult<T>> {
    private final List<Pair<String, T>> results = new ArrayList<>();

    @Override
    public void collect(Object element, VisitorContext context) {
        if (appliesTo(element, context)) {
            Pair<String, T> pair = Pair.of(context.toPath(), (T) element);
            this.results.add(pair);
        }
    }

    @Override
    public FinderMetricResult<T> getResult() {
        return new FinderMetricResult<>(results);
    }
}
