package com.workflow.bpmn.model.obfuscation;

import com.workflow.bpmn.model.AbstractTest;
import org.junit.Test;

import java.io.File;

public class BPMNObfuscatorTest extends AbstractTest {
    private final BPMNObfuscator obfuscator = new BPMNObfuscator();

    @Test
    public void testObfuscate() throws Exception {
        String inputFileName = "test-1.bpmn";
        String inputPath = "bpmn/input/" + inputFileName;
        String targetPath = "target/" + inputFileName;
        String expectedPath = "bpmn/expected/" + inputFileName;

        File inputFile = new File(resource(inputPath));
        File outputFile = new File(targetPath);
        obfuscator.obfuscate(inputFile, outputFile);

        File expectedFile = new File(resource(expectedPath));
        compareFile(expectedFile, outputFile);
    }

    @Test(expected = NullPointerException.class)
    public void testObfuscateWhenInputIsNull() throws Exception {
        File inputFile = null;
        File outputFile = null;
        obfuscator.obfuscate(inputFile, outputFile);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObfuscateWhenInputDoesNotExist() throws Exception {
        File inputFile = new File("missing");
        File outputFile = new File("output");
        obfuscator.obfuscate(inputFile, outputFile);
    }

    @Test(expected = NullPointerException.class)
    public void testObfuscateWhenOutputIsNull() throws Exception {
        File inputFile = new File("missing");
        File outputFile = null;
        obfuscator.obfuscate(inputFile, outputFile);
    }
}