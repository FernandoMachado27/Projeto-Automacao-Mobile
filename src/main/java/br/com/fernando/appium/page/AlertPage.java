package br.com.fernando.appium.page;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;

public class AlertPage extends BasePage{
	
	public void clicarAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}

	public void clicarForaCaixa() {
		tap(100, 150);
	}
	
		
}
