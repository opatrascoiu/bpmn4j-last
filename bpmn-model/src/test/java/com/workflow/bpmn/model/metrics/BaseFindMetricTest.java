package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.AbstractTest;
import com.workflow.bpmn.model.metrics.finder.Finder;
import com.workflow.bpmn.model.metrics.finder.FinderMetricResult;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class BaseFindMetricTest<T> extends AbstractTest {
    protected void doTest(List<Pair<String, String>> expected, String inputPath) {
        File inputFile = new File(resource(inputPath));
        FinderMetricResult<T> result = (FinderMetricResult<T>) makeMetric().measure(List.of(inputFile));
        assertEquals(normalizeList(expected), normalizeList(serialize(result.getResults())));
    }

    private CollectNodesMetric makeMetric() {
        return new CollectNodesMetric(makeFinder());
    }

    private List<Pair<String, String>> normalizeList(List<Pair<String, String>> list) {
        if (list == null) {
            return null;
        }

        list.sort(Comparator.comparing(Pair::toString));
        return list;
    }

    protected List<Pair<String, String>> serialize(List<Pair<String, T>> results) {
        List<Pair<String, String>> serialization = new ArrayList<>();
        for (Pair<String, T> result: results) {
            serialization.add(Pair.of(result.getLeft(), toString(result.getRight())));
        }
        return serialization;
    }

    protected abstract Finder<T> makeFinder();

    protected abstract String toString(T right);
}