package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.FormularioPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OpcaoEscondidaTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		// scroll down 
		menu.scrollDown(); // de 90% da tela até 10% 
		
		// clicar menu 
		menu.clicarPorTexto("Opção bem escondida");
		
		// verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		// sair 
		menu.clicarPorTexto("OK");
	}

}
