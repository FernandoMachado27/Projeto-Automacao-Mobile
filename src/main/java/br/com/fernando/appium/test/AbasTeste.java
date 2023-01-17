package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.AbasPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AbasTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveInteragirComAbas() {
		// acessar menu abas
		menu.acessarAbas();
		
		// verificar que está na aba 1
		Assert.assertTrue(abas.isAba1());
		
		// acessar aba 2
		abas.selecionarAba2();
		
		// verificar que está na aba 2
		Assert.assertTrue(abas.isAba2());
	}

}
