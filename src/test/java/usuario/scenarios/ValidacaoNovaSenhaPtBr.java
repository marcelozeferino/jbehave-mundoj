package test.java.usuario.scenarios;

import test.java.usuario.steps.ValidacaoNovaSenhaStepsPtBr;

public class ValidacaoNovaSenhaPtBr extends ScenarioPtBR {
    
	public ValidacaoNovaSenhaPtBr(){	
		addSteps(new ValidacaoNovaSenhaStepsPtBr());
	}

}
