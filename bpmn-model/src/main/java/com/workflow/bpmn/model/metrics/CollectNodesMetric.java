package com.workflow.bpmn.model.metrics;

import com.workflow.bpmn.model.BPMNModelRepository;
import com.workflow.bpmn.model.VisitorContext;
import com.workflow.bpmn.model.log.BuildLogger;
import com.workflow.bpmn.model.log.Slf4jBuildLogger;
import com.workflow.bpmn.model.serialization.BPMNReader;
import org.omg.spec.bpmn._20100524.model.*;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CollectNodesMetric<R> extends SimpleMetric<R> {
    protected static final BuildLogger LOGGER = new Slf4jBuildLogger(LoggerFactory.getLogger(CollectNodesMetric.class));

    private final BPMNReader reader  = new BPMNReader(LOGGER, false);

    protected final MetricCollector<R> collector;

    public CollectNodesMetric(MetricCollector<R> collector) {
        super("Find Elements");
        this.collector = collector;
    }

    @Override
    public R measure(List<File> files) {
        BPMNModelRepository repository = readModels(files);
        return measure(repository);
    }

    public R measure(BPMNModelRepository repository) {
        List<TDefinitions> models = repository.getModels();
        if (models != null) {
            for (TDefinitions model: models) {
                visitModel(model);
            }
        }
        return this.collector.getResult();
    }

    private BPMNModelRepository readModels(List<File> files) {
        List<TDefinitions> models = new ArrayList<>();
        for (File file: files) {
            TDefinitions model = this.reader.read(file);
            models.add(model);
        }
        return new BPMNModelRepository(models);
    }

    private void visitModel(TDefinitions model) {
        VisitorContext modelContext = VisitorContext.of(null, model);
        CollectVisitor<R> visitor = new CollectVisitor<>(this.collector);
        visitor.visit(model, modelContext);
    }
}
