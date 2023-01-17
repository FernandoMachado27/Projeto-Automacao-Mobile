package br.com.fernando.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;

public class SBContasPage extends BasePage{
	
	public void setConta(String nome) {
		DriverFactor.getDriver().findElement(By.className("android.widget.EditText")).sendKeys(nome);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}

}
