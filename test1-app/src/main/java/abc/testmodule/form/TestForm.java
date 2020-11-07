package abc.testmodule.form;

import java.util.Arrays;
import java.util.function.Predicate;
import javax.annotation.Nonnull;

import org.opensingular.form.SIComposite;
import org.opensingular.form.SInfoType;
import org.opensingular.form.SInstance;
import org.opensingular.form.STypeComposite;
import org.opensingular.form.TypeBuilder;
import org.opensingular.form.type.core.STypeBoolean;
import org.opensingular.form.type.core.STypeString;
import org.opensingular.form.view.SViewByBlock;

import static org.opensingular.form.util.SingularPredicates.typeValueIsTrueAndNotNull;

@SInfoType(label = "Formulário")
public class TestForm extends STypeComposite<SIComposite> {
    public STypeString nomeCompleto;

    @Override
    protected void onLoadType(@Nonnull TypeBuilder tb) {
        nomeCompleto = addFieldString("nomeCompleto");
        nomeCompleto
                .asAtr()
                .required()
                .label("Nome completo")
                .asAtrAnnotation()
                .setAnnotated();

        this.asAtr()
                .displayString("${nomeCompleto!}");

        this.withView(new SViewByBlock(), block ->
                block.newBlock("Requerimento").add(nomeCompleto)
        );
    }
}