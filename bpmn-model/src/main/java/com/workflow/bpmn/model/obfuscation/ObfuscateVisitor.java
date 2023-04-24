package com.workflow.bpmn.model.obfuscation;

import com.workflow.bpmn.model.BPMNVisitor;
import com.workflow.bpmn.model.VisitorContext;
import org.omg.spec.bpmn._20100524.model.*;

import javax.xml.namespace.QName;
import java.util.Map;

public class ObfuscateVisitor implements BPMNVisitor {
    private final BPMNObfuscator obfuscator;

    public ObfuscateVisitor(BPMNObfuscator obfuscator) {
        this.obfuscator = obfuscator;
    }

    @Override
    public void visit(TDataState element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TLane element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCategoryValue element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TResourceParameter element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TChoreographyTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSubChoreography element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCallChoreography element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCallActivity element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TTask element, VisitorContext context) {
        if (element != null) {
            if (TTask.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TServiceTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TManualTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSendTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TUserTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TBusinessRuleTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TReceiveTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TScriptTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSubProcess element, VisitorContext context) {
        if (element != null) {
            if (TSubProcess.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TTransaction element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TAdHocSubProcess element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGateway element, VisitorContext context) {
        if (element != null) {
            if (TGateway.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TInclusiveGateway element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TExclusiveGateway element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TComplexGateway element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TParallelGateway element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TEventBasedGateway element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TIntermediateThrowEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TImplicitThrowEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TEndEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TBoundaryEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TStartEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TIntermediateCatchEvent element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataStoreReference element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataObjectReference element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSequenceFlow element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataObject element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TRelationship element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCategory element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCorrelationProperty element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSignal element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TResource element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TItemDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TPartnerEntity element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TEscalation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TPartnerRole element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMessage element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCollaboration element, VisitorContext context) {
        if (element != null) {
            if (TCollaboration.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TGlobalConversation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TChoreography element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalChoreographyTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataStore element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TInterface element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TError element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TEndPoint element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCallableElement element, VisitorContext context) {
        if (element != null) {
            if (TCallableElement.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TProcess element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalBusinessRuleTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalUserTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalManualTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGlobalScriptTask element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSignalEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TConditionalEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMessageEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCancelEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TErrorEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TEscalationEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TTerminateEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TTimerEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCompensateEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TLinkEventDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TResourceRole element, VisitorContext context) {
        if (element != null) {
            if (TResourceRole.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TPerformer element, VisitorContext context) {
        if (element != null) {
            if (TPerformer.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(THumanPerformer element, VisitorContext context) {
        if (element != null) {
            if (THumanPerformer.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TPotentialOwner element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMessageFlowAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TAssignment element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }
    @Override
    public void visit(TResourceParameterBinding element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }
    @Override
    public void visit(TCorrelationPropertyRetrievalExpression element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }
    @Override
    public void visit(TDataInput element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TConversationAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMessageFlow element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TInputOutputBinding element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TLaneSet element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TAuditing element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TOutputSet element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMonitoring element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TParticipantMultiplicity element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TProperty element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCorrelationSubscription element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TComplexBehaviorDefinition element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TInputOutputSpecification element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TInputSet element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TParticipantAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TOperation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TRendering element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TSubConversation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCallConversation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TConversation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TParticipant element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TMultiInstanceLoopCharacteristics element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TStandardLoopCharacteristics element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataOutput element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCorrelationKey element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TConversationLink element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TCorrelationPropertyBinding element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TGroup element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TTextAnnotation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataAssociation element, VisitorContext context) {
        if (element != null) {
            if (TDataAssociation.class.equals(element.getClass())) {
                obfusctateElement(element, context);
            }
            BPMNVisitor.super.visit(element, context);
        }
    }

    @Override
    public void visit(TDataOutputAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TDataInputAssociation element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TResourceAssignmentExpression element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    // Other
    @Override
    public void visit(TDocumentation element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(TExtensionElements element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(TScript element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(TExpression element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(TText element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(Map<QName, String> element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(TImport element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(TExtension element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    // Diagram
    @Override
    public void visit(BPMNDiagram element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(Bounds element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(BPMNLabelStyle element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(DiagramElement.Extension element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(BPMNEdge element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(BPMNLabel element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(BPMNShape element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(BPMNPlane element, VisitorContext context) {
        obfusctateElement(element, context);
        BPMNVisitor.super.visit(element, context);
    }

    @Override
    public void visit(Font element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    @Override
    public void visit(Point element, VisitorContext context) {
        obfusctateElement(element, context);
    }

    private void obfusctateElement(Object element, VisitorContext context) {
        this.obfuscator.obfuscate(element, context);
    }
}
