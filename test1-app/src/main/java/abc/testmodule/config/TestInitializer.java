package abc.testmodule.config;

import org.opensingular.requirement.studio.init.RequirementStudioAppInitializer;

public class TestInitializer extends RequirementStudioAppInitializer {
    @Override
    public String[] getSpringPackagesToScan() {
        return new String[]{"abc"};
    }
}