package com.workflow.bpmn.model.metrics;

public abstract class SimpleMetric<R> implements Metric<R> {
    private final String name;

    protected SimpleMetric(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
