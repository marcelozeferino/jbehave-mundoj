package test.java.usuario.steps;



import main.java.usuario.Usuario;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Named;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import static org.jbehave.Ensure.ensureThat;

public class ValidacaoNovaSenhaSteps extends Steps {
	 
	private Usuario usuario = new Usuario();
	
	private String mensagemErro;
	
	@Given("Um usuário de nome: <nome> e login: <login> e a senha: <senha>")
	public void setUp(@Named("nome") String nomeUsuario, @Named("login") String loginUsuario, @Named("senha") String novaSenha) {
		
		mensagemErro = "";
		usuario.setNome(nomeUsuario);
		usuario.setLogin(loginUsuario);
		usuario.setSenha(novaSenha);
		
	}
	
	@When("verifico se a senha é segura")
	public void checkSenha() {

		try{
			usuario.validarNovaSenha();
		}catch (Exception e) {
			mensagemErro = e.getMessage();
		}
		
	}

	@Then("Deve retornar a mensagem: <mensagem>")
	public void checkMessagem(@Named("mensagem") String mensagem) {
		ensureThat(mensagemErro.trim().equalsIgnoreCase(mensagem));
	}

}
