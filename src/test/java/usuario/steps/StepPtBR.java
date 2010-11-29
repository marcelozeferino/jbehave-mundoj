package test.java.usuario.steps;

import java.util.Locale;

import org.jbehave.scenario.definition.KeyWords;
import org.jbehave.scenario.i18n.I18nKeyWords;
import org.jbehave.scenario.i18n.StringEncoder;
import org.jbehave.scenario.steps.Steps;
import org.jbehave.scenario.steps.StepsConfiguration;

public class StepPtBR extends Steps {

	 public StepPtBR(){
		 this(Thread.currentThread().getContextClassLoader());
	 }
	 
	 //Definindo que serão utilizados os keywords traduzidos
	 public StepPtBR(ClassLoader classLoader) {
	    super(new StepsConfiguration(keywordsFor(new Locale("pt"), classLoader)));
	 }
	 
	//Aqui, definimos o pacote onde está inserido o arquivo properties contendo o 
	//mapeamento das palavras chaves traduzidas para o Português
	 protected static KeyWords keywordsFor(Locale locale, ClassLoader classLoader) {
			return new I18nKeyWords(locale, new StringEncoder(), "test/resources/keywords", classLoader);
	}


}
