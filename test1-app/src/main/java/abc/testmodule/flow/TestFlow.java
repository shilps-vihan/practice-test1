package abc.testmodule.flow;

import org.opensingular.flow.core.DefinitionInfo;
import org.opensingular.flow.core.FlowInstance;
import org.opensingular.flow.core.ITaskDefinition;
import org.opensingular.flow.core.defaults.PermissiveTaskAccessStrategy;
import org.opensingular.requirement.module.flow.builder.RequirementFlowBuilder;
import org.opensingular.requirement.module.flow.builder.RequirementFlowDefinition;
import org.opensingular.requirement.module.wicket.view.form.FormPage;
import abc.testmodule.TestModule;
import abc.testmodule.page.AnaliseTecnicaPage;

import javax.annotation.Nonnull;

import static abc.testmodule.flow.TestFlow.Tasks.ANALISAR;
import static abc.testmodule.flow.TestFlow.Tasks.APROVADO;
import static abc.testmodule.flow.TestFlow.Tasks.REPROVADO;
import static abc.testmodule.flow.TestFlow.Tasks.SOLICITACAO_COM_PENDENCIAS;


@DefinitionInfo("test")
public class TestFlow extends RequirementFlowDefinition<FlowInstance> {

        public static final String SOLICITAR_AJUSTES = "Solicitar ajustes";
        public static final String APROVAR = "Aprovar";
        public static final String REPROVAR = "Reprovar";
        public static final String CONCLUIR_PENDÊNCIA = "Concluir Pendência";

        public enum Tasks implements ITaskDefinition {
        ANALISAR("Analisar"),
        APROVADO("Aprovado"),
        REPROVADO("Reprovado"),
        SOLICITACAO_COM_PENDENCIAS("Solicitação com pendências");

        private String taskName;

        Tasks(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public String getName() {
            return taskName;
        }
    }

    public TestFlow() {
        super(FlowInstance.class);
        this.setName(TestModule.test, "Test");
    }

    @Override
    protected void buildFlow(@Nonnull RequirementFlowBuilder flow) {

        flow.addHumanTask(ANALISAR)
                .uiAccess(new PermissiveTaskAccessStrategy())
                .withExecutionPage(AnaliseTecnicaPage.class);

        flow.addWaitTask(SOLICITACAO_COM_PENDENCIAS)
                .uiAccess(new PermissiveTaskAccessStrategy())
                .withExecutionPage(FormPage.class);

        flow.addEndTask(REPROVADO);
        flow.addEndTask(APROVADO);

        flow.setStartTask(ANALISAR);

        flow.from(ANALISAR).go(SOLICITAR_AJUSTES, SOLICITACAO_COM_PENDENCIAS);
        flow.from(ANALISAR).go(APROVAR, APROVADO);
        flow.from(ANALISAR).go(REPROVAR, REPROVADO);

        flow.from(SOLICITACAO_COM_PENDENCIAS).go(CONCLUIR_PENDÊNCIA, ANALISAR);
    }

}