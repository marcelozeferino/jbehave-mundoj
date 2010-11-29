package test.java.usuario.scenarios;

import java.util.Locale;

import org.jbehave.scenario.JUnitScenario;
import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.definition.KeyWords;
import org.jbehave.scenario.i18n.I18nKeyWords;
import org.jbehave.scenario.i18n.StringEncoder;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.ScenarioDefiner;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;
import org.jbehave.scenario.reporters.PrintStreamScenarioReporter;
import org.jbehave.scenario.reporters.ScenarioReporter;

public class ScenarioPtBR extends JUnitScenario {
	 
	public ScenarioPtBR() {
		this(Thread.currentThread().getContextClassLoader());
	}
	
    public ScenarioPtBR(final ClassLoader classLoader) {
    	
        super(new PropertyBasedConfiguration() {
        	
            @SuppressWarnings("deprecation")
			@Override
            public ScenarioDefiner forDefiningScenarios() {
            	
                // Repare que aqui estamos utilizando a extensão .cenario e não 
            	// .scenario, como antes
                return new ClasspathScenarioDefiner(
                        new UnderscoredCamelCaseResolver(".cenario"),
                        new PatternScenarioParser(this), classLoader);
            }
 
            @Override
            public ScenarioReporter forReportingScenarios() {
                //definição do Locale para "pt"
                return new PrintStreamScenarioReporter(keywordsFor(new Locale("pt"), classLoader));
            }
 
            @Override
            public KeyWords keywords() {
                return keywordsFor(new Locale("pt"), classLoader);
            }
 
        });
    }
 
    //Aqui está sendo definido o pacote onde está inserido o arquivo properties com 
    //mapeamento das palavras chaves traduzidas para o Português
    protected static KeyWords keywordsFor(Locale locale, ClassLoader classLoader) {
        return new I18nKeyWords(locale, new StringEncoder(), "test/resources/keywords", classLoader);
    }
 
}


