package com.workflow.bpmn.model.metrics;

import java.io.File;
import java.util.List;

public interface Metric<R> {
    String getName();

    R measure(List<File> files);
}
