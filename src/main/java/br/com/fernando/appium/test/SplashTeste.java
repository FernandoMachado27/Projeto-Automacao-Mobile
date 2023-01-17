package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.MenuPage;
import br.com.fernando.appium.page.SplashPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SplashTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveAguardarSplashSumir() {
		// acessar menu splash
		menu.acessarSplash();
		
		// verificar que o splash está sendo exibido
		splash.isTelaSplashVisivel();
		
		// aguardar saida do splash
		splash.aguardarSplashSumir();
		
		// verificar que o formulário está aparecendo
		Assert.assertTrue(splash.existeUmElementoPorTexto("Formulário"));
	}

}
