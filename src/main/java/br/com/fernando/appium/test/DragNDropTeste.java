package br.com.fernando.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fernando.appium.core.BaseTest;
import br.com.fernando.appium.core.DriverFactor;
import br.com.fernando.appium.page.DragDropPage;
import br.com.fernando.appium.page.FormularioPage;
import br.com.fernando.appium.page.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DragNDropTeste extends BaseTest{ // segurar e arrastar
	
	private AndroidDriver<MobileElement> driver;
	private MenuPage menu = new MenuPage();
	private DragDropPage drag = new DragDropPage();
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."}; // array
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Before
	public void before() throws MalformedURLException {
		driver = DriverFactor.permissoes();
	}
	
	@Test
	public void deveEfetuarDragNDrop() {
		// acessar menu 
		menu.clicarDragNDrop();
		
		// verificar estado incial 
		Assert.assertArrayEquals(estadoInicial, drag.obterLista());
		esperar(1000);
		
		// arrastar "Esta" para "e arraste para"
		drag.arrastar("Esta", "e arraste para");
		
		// verificar estado intermedi�rio
		Assert.assertArrayEquals(estadoIntermediario, drag.obterLista());
		
		// arrastar "Fa�a clique longo," para "� uma lista"
		drag.arrastar("Fa�a um clique longo,", "� uma lista");
		
		// verificar estado final
		Assert.assertArrayEquals(estadoFinal, drag.obterLista());
		
	}

}
