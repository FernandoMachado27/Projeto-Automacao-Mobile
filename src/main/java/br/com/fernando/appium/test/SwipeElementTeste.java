package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.FormularioPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwipeElementTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveResolverDesafio() { // fazer depois - 40. Desafio: Swipe List
		// clicar swipe list 
		
		// op 1 para esquerda 
		
		// op 1 +
		
		// verificar op 1 + 
		
		// op 4 para esquerda 
		
		// op 4 -
		
		// verificar op 4
		
		// op 5 para direita 
		
		// verificar op 5 
		
		
	}

}
