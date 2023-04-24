package com.workflow.bpmn.model.log;

public interface BuildLogger {
    void debug(String msg);

    void info(String msg);

    void warn(String msg);

    void error(String msg);

    void error(String msg, Throwable e);
}
