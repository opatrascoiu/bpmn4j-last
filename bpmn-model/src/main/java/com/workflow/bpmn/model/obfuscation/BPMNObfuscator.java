package com.workflow.bpmn.model.obfuscation;

import com.workflow.bpmn.model.VisitorContext;
import com.workflow.bpmn.model.log.Slf4jBuildLogger;
import com.workflow.bpmn.model.serialization.BPMNReader;
import com.workflow.bpmn.model.serialization.BPMNWriter;
import org.omg.spec.bpmn._20100524.model.TDefinitions;
import org.omg.spec.bpmn._20100524.model.TFlowElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

public class BPMNObfuscator {
    private static final Logger LOGGER = LoggerFactory.getLogger(BPMNObfuscator.class);

    private final BPMNReader reader = new BPMNReader(new Slf4jBuildLogger(LOGGER), true);
    private final BPMNWriter writer = new BPMNWriter(new Slf4jBuildLogger(LOGGER));

    public void obfuscate(File inputFile, File outputFile) throws Exception {
        Objects.requireNonNull(inputFile, "Missing input file");
        Objects.requireNonNull(outputFile, "Missing output file file");
        if (!inputFile.exists()) {
            throw new IllegalArgumentException(String.format("Cannot find file '%s'", inputFile.getAbsolutePath()));
        }

        // Read model
        TDefinitions definitions = reader.read(inputFile);
        // Obfuscate
        visitModel(definitions, VisitorContext.of(null, definitions));
        // Write model
        writer.write(definitions, outputFile);
    }

    private void visitModel(TDefinitions model, VisitorContext context) {
        VisitorContext modelContext = VisitorContext.of(null, model);
        ObfuscateVisitor visitor = new ObfuscateVisitor(this);
        visitor.visit(model, modelContext);
    }

    public void obfuscate(Object element, VisitorContext context) {
        if (element instanceof TFlowElement) {
            ((TFlowElement) element).setName(((TFlowElement) element).getId());
        }
    }
}
