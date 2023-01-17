package br.com.fernando.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.FormularioPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto(){
		formulario.escreverNome("Fernando");
		
		formulario.checarNome("Fernando");
	}
	
	@Test
	public void deveInteragirCombo(){
		formulario.selecionarCombo("Nintendo Switch");
		
		formulario.checarComboSelecionado("Nintendo Switch");
	}
	
	@Test
	public void deveComSwitchECheckbox(){
		Assert.assertFalse(formulario.isCheckMarcado()); // método que é apenas alterar o By 
		Assert.assertTrue(formulario.isSwitchMarcado());
			
		formulario.clicarCheck();
		formulario.clicarSwitch();
		
		Assert.assertTrue(formulario.isCheckMarcado()); // método que é apenas alterar o By 
		Assert.assertFalse(formulario.isSwitchMarcado());
	}
	
	@Test
	public void deveRealizarCadastro(){		
		formulario.escreverNome("Fernando");;
		
		formulario.selecionarCombo("Nintendo Switch");
		
		formulario.clicarCheck();
		formulario.clicarSwitch();

		formulario.clicarSalvar();

		Assert.assertEquals("Nome: Fernando", formulario.checarNomeCadastrado());
		Assert.assertEquals("Console: switch", formulario.checarConsoleCadastrado());
		Assert.assertTrue(formulario.checarCheckCadastrado().endsWith("Marcado"));
		Assert.assertTrue(formulario.checarSwitchCadastrado().endsWith("Off"));
	}
	
	@Test
	public void deveRealizarCadastroDemorado(){		
		formulario.escreverNome("Fernando");
		
		DriverFactor.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // -> aplicações mobile tem funcionado
		
		formulario.clicarSalvarDemorado();
//		esperar(3000); -> menos recomendado
		WebDriverWait wait = new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Fernando']"))); // mais usado em web mas usar em mobile se implicitly não funcionar

		Assert.assertEquals("Nome: Fernando", formulario.checarNomeCadastrado());
	}
	
	@Test
	public void deveAlterarData() {
		formulario.clicarPorTexto("01/01/2000");
		formulario.clicarPorTexto("20");
		formulario.clicarPorTexto("OK");
		Assert.assertTrue(formulario.existeUmElementoPorTexto("20/2/2000"));
	}
	
//	@Test
//	public void deveAlterarHora() {
//		formulario.clicarPorTexto("06:00");
//		formulario.clicarPorTexto("10");
//		formulario.clicarPorTexto("40");
//		formulario.clicarPorTexto("OK");
//		Assert.assertTrue(formulario.existeUmElementoPorTexto("10:40"));
//	}
	
	@Test
	public void deveInteragirComSeekBar() {
		// clicar no seek bar
		formulario.clicarSeekBar(0.05);
		
		// salvar 
		formulario.clicarSalvar();
		
		// obter o valor 
	}

	
}
