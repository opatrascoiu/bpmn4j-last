package com.workflow.bpmn.model.metrics.finder;

import com.workflow.bpmn.model.VisitorContext;
import org.omg.spec.bpmn._20100524.model.TExpression;
import org.omg.spec.bpmn._20100524.model.TMultiInstanceLoopCharacteristics;

import java.io.Serializable;
import java.util.List;

//
// Finds only MultiInstanceLoopCharacteristics
//
public class MultiInstanceLoopCharacteristicsFinder extends Finder<TMultiInstanceLoopCharacteristics> {
    @Override
    public boolean appliesTo(Object element, VisitorContext context) {
        if (!(element instanceof TMultiInstanceLoopCharacteristics)) {
            return false;
        }
        TExpression completionCondition = ((TMultiInstanceLoopCharacteristics) element).getCompletionCondition();
        if (completionCondition == null) {
            return false;
        }
        List<Serializable> content = completionCondition.getContent();
        if (content == null) {
            return false;
        }
        for (Serializable part: content) {
            if ("${nrOfCompletedInstances == 1}".equals(part)) {
                return true;
            }
        }
        return false;
    }
}
