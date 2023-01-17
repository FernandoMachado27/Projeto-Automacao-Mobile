package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.CliquesPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CliquesTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	private CliquesPage cliques = new CliquesPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
//	@Test
//	public void deveRealizarCliqueLongo() {
//		// acessar menu 
//		menu.acessarCliques();
//		
//		// clique longo
//		cliques.cliqueLongo();
//		
//		// verificar texto
//		Assert.assertEquals("Clique Longo", cliques.obterTextoCampo());
//	}
//	
//	@Test
//	public void deveRealizarCliqueDuplo() {
//		menu.acessarCliques();
//		cliques.clicarPorTexto("Clique duplo");
//		cliques.clicarPorTexto("Clique duplo");
//		Assert.assertEquals("Clique duplo", cliques.obterTexto());
//	}

}
