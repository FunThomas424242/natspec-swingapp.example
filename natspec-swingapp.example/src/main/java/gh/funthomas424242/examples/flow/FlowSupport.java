package gh.funthomas424242.examples.flow;

import gh.funthomas424242.examples.flow.support.Flow;
import gh.funthomas424242.examples.flow.support.SubFlow;
import gh.funthomas424242.examples.gui.HalloWeltDialog;
import gh.funthomas424242.examples.gui.LoginDialog;
import gh.funthomas424242.examples.gui.StartDialog;
import gh.funthomas424242.examples.lib.BusinessModel;
import gh.funthomas424242.examples.lib.DialogModelElement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.devboost.natspec.annotations.TextSyntax;

public class FlowSupport {

    final protected BusinessModel model;
    final protected Flow supportedFlow;

    public FlowSupport(final BusinessModel model, final Flow supportedFlow) {
        this.model = model;
        this.supportedFlow = supportedFlow;
    }

    @TextSyntax("Nutze den Registrierten Flow.")
    public Flow nutzeDenRegistriertenFlow() {
        return supportedFlow;
    }

    @TextSyntax("Erstelle den Flow #1")
    public Flow erstelleDenFlow(String flowId) {
        // final Flow flow= new Flow(model);
        // flow.setFlowName(flowId);
        // return flow;
        supportedFlow.setFlowName(flowId);
        return supportedFlow;
    }

    @TextSyntax("Erstelle einen HalloWeltDialog.")
    public DialogModelElement erstelleEinenHelloLabeldialog() {
        return new HalloWeltDialog().createDialog();
    }

    @TextSyntax("Erstelle einen StartDialog.")
    public DialogModelElement createStartDialog() {
        return new StartDialog().createDialog();
    }

    @TextSyntax("Erstelle einen Logindialog.")
    public DialogModelElement erstelleEinenLogindialog() {
        return new LoginDialog().createDialog();
    }

    @TextSyntax("Registriere am Button #1 den LoginFlow.")
    public void registriereLoginFlowAmButton(final String elementId,
            final DialogModelElement dialog, final Flow parentFlow) {
        final SubFlow loginFlow = new LoginFlow(this.model, parentFlow);
        registerDialogAtButton(loginFlow, dialog, elementId, parentFlow);
    }

    @TextSyntax("Registriere am Button #1 den SchliessenFlow.")
    public void registriereSchliessenFlowAmButton(final String elementId,
            final DialogModelElement dialog, final Flow parentFlow) {
        final SubFlow loginFlow = new SchliessenFlow(this.model, parentFlow);
        registerDialogAtButton(loginFlow, dialog, elementId, parentFlow);
    }

    @TextSyntax("Registriere am Button #1 den BeendenFlow.")
    public void registriereBeendenFlowAmButton(final String elementId,
            final DialogModelElement dialog, final Flow parentFlow) {
        final SubFlow loginFlow = new BeendenFlow(this.model, parentFlow);
        registerDialogAtButton(loginFlow, dialog, elementId, parentFlow);
    }

    protected void registerDialogAtButton(final SubFlow flow,
            final DialogModelElement dialog, final String elementId,
            final Flow parentFlow) {

        flow.setRufenderDialog(dialog);
        final JButton button = (JButton) dialog.getElement(elementId);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flow.run();
            }
        });
    }

    @TextSyntax("Schliesse den rufenden Dialog.")
    public void schliesseDenRufendenDialog(final Flow flow) {
        DialogModelElement dialog = flow.getRufenderDialog();
        dialog.schliesseDialog();

    }

    @TextSyntax("Beende die Anwendung.")
    public void beendeDieAnwendung() {
        System.exit(0);
    }

}
