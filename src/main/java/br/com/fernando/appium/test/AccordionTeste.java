package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.AccordionPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AccordionTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveInteragirComAccordion() {
		// acessar menu 
		menu.acessarAccordion();
		
		// clicar opção 1
		accordion.selecionarOp1();
		
		// verificar texto opção 1
		esperar(1000);
		Assert.assertEquals("Opção 1", accordion.obterValorOp1());
		
	}

}
