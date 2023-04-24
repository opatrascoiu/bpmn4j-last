package com.workflow.bpmn.model.log;

import org.slf4j.Logger;

public final class Slf4jBuildLogger implements BuildLogger {
    private final Logger logger;

    public Slf4jBuildLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(String msg) {
        this.logger.debug(msg);
    }

    @Override
    public void info(String msg) {
        this.logger.info(msg);
    }

    @Override
    public void warn(String msg) {
        this.logger.warn(msg);
    }

    @Override
    public void error(String msg) {
        this.logger.error(msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        this.logger.error(msg, t);
    }
}
