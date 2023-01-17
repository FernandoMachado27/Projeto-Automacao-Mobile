package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.AlertPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AlertTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AlertPage alert = new AlertPage();
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		// clicar em alerta confirm 
		alert.clicarAlertConfirm();
		
		// verificar os textos 
		Assert.assertEquals("Info", alert.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alert.obterMensagemAlerta());
		
		// confirmar alerta 
		alert.confirmar();
		
		// verificar nova mensagem 
		Assert.assertEquals("Confirmado", alert.obterMensagemAlerta());
		
		// sair 
		alert.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		// clicar alerta simples]
		alert.clicarAlertaSimples();
		
		// clicar fora da caixa 
		esperar(1000);
		alert.clicarForaCaixa();
		
		// verificar que a mensagem não está presente
		Assert.assertFalse(alert.existeUmElementoPorTexto("pode clicar no OK ou fora da caixa para sair"));
	}

}
