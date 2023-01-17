package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.MenuPage;
import br.com.fernando.appium.page.seuBarriga.SBContasPage;
import br.com.fernando.appium.page.seuBarriga.SBLoginPage;
import br.com.fernando.appium.page.seuBarriga.SBMenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SBTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	private SBLoginPage sbLogin = new SBLoginPage();
	private SBMenuPage sbMenu = new SBMenuPage();
	private SBContasPage sbConta = new SBContasPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
		menu.acessarSBNativo();
		sbLogin.setEmail("fernandooo@gmail.com");
		sbLogin.setSenha("Senha");
		sbLogin.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso() {
		// entrar em contas 
		sbMenu.acessarContas();
		
		// digitar nome conta 
		sbConta.setConta("Conta de teste");
		
		// salvar 
		sbConta.salvar();
		
		// verificar mensagem
		Assert.assertTrue(sbConta.existeUmElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		// entrar em contas 
		sbMenu.acessarContas();
		
		// clique longo na conta 
		sbConta.selecionarConta("Conta Excluir");
		
		// excluir
		sbConta.excluir();
		
		// verificar mensagem
		Assert.assertTrue(sbConta.existeUmElementoPorTexto("Conta excluída com sucesso"));
		
	}
	

}
