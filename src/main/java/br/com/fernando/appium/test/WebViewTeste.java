package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.MenuPage;
import br.com.fernando.appium.page.WebViewPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WebViewTeste extends BaseTest{
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	private WebViewPage web = new WebViewPage();
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveFazerLogin() { // **************mudar versão chrome driver para rodar***************
		// acessar menu 
		menu.acessarSBHibrido();
		esperar(3000);
		web.entrarContextoWeb();
		
		// preencher email
		web.setEmail("a@a");
		
		// senha 
		web.setSenha("senha");
		
		// entrar 
		web.entrarConta();
		
		// verificar 
		Assert.assertEquals("Bem vindo, Fernando", web.getMensagem());
		
	}
	
	@After
	public void after() {
		web.sairContextoWeb();
	}

}
