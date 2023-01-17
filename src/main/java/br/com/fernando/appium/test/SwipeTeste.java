package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwipeTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveRealizarSwipe() {
		// acessar menu
		menu.acessarSwipe();
		
		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));
		
		// swipe para direita 
		menu.swipeRight(); // de 90% a 10%
		
		// verificar o texto 'E veja se'
		Assert.assertTrue(menu.existeUmElementoPorTexto("E veja se"));
		
		// clicar botão direita 
		menu.clicarPorTexto("›");
		
		// verificar o texto 'Chegar até o fim'
		Assert.assertTrue(menu.existeUmElementoPorTexto("Chegar até o fim!"));
		
		// swipe esquerda 
		menu.swipeLeft();
		
		// clicar botão esquerda 
		menu.clicarPorTexto("‹");
		
		// verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));
	}

}
