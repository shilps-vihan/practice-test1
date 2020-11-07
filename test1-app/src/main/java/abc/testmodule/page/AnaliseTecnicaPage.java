package abc.testmodule.page;

import  abc.testmodule.flow.TestFlow;
import  abc.testmodule.form.STParecerTecnico;
import  abc.testmodule.transition.SimpleTransitionController;
import org.opensingular.requirement.module.wicket.view.form.FormPage;
import org.opensingular.requirement.module.wicket.view.form.TransitionController;
import org.opensingular.requirement.module.wicket.view.util.ActionContext;

import javax.annotation.Nullable;
import java.util.Map;

public class AnaliseTecnicaPage extends FormPage {
    public AnaliseTecnicaPage() {
    }

    public AnaliseTecnicaPage(@Nullable ActionContext context) {
        super(context);
    }

    @Override
    protected void fillTransitionControllerMap(Map<String, TransitionController<?>> transitionControllerMap) {
        super.fillTransitionControllerMap(transitionControllerMap);
        transitionControllerMap.put(TestFlow.APROVAR, new SimpleTransitionController<>(STParecerTecnico.class));
        transitionControllerMap.put(TestFlow.REPROVAR, new SimpleTransitionController<>(STParecerTecnico.class));
    }
}