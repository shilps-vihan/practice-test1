package abc.testmodule;

import org.opensingular.requirement.module.RequirementDefinition;
import org.opensingular.requirement.module.builder.RequirementConfigurationBuilder;
import org.opensingular.requirement.module.builder.RequirementDefinitionConfiguration;
import org.opensingular.requirement.module.service.RequirementInstance;
import abc.testmodule.form.TestForm;
import abc.testmodule.flow.TestFlow;

public class TestRequirement extends RequirementDefinition<RequirementInstance> {
    public TestRequirement() {
        super(TestRequirement.class.getSimpleName(), RequirementInstance.class);
    }

    @Override
    public RequirementDefinitionConfiguration configure(RequirementConfigurationBuilder conf) {
        return conf
                .name("Formulário Test")
                .mainForm(TestForm.class)
                .flowDefintion(TestFlow.class)
                .build();
    }
}