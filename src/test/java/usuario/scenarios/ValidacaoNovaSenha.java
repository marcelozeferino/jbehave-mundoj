package test.java.usuario.scenarios;

import org.jbehave.scenario.JUnitScenario;
import org.jbehave.scenario.MostUsefulConfiguration;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import org.jbehave.scenario.reporters.PrintStreamScenarioReporter;
import org.jbehave.scenario.reporters.ScenarioReporter;

import test.java.usuario.steps.ValidacaoNovaSenhaSteps;

public class ValidacaoNovaSenha extends JUnitScenario {

	public ValidacaoNovaSenha() {

		super(new MostUsefulConfiguration() {
			
            public ScenarioDefiner forDefiningScenarios() {
                return new ClasspathScenarioDefiner(
                		new UnderscoredCamelCaseResolver(".scenario"),
                             new PatternScenarioParser(keywords()));
            }
            
            @Override
			public ScenarioReporter forReportingScenarios() {

				return new PrintStreamScenarioReporter();
				
			}

        });
		
		addSteps(new ValidacaoNovaSenhaSteps()); 	
		
	}
	
}
