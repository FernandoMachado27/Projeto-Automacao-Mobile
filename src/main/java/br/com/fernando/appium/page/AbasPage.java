package br.com.fernando.appium.page;

import br.com.fernando.appium.core.BasePage;

public class AbasPage extends BasePage{

	public boolean isAba1() {
		return existeUmElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeUmElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void selecionarAba2() {
		clicarPorTexto("ABA 2");
	}

}
