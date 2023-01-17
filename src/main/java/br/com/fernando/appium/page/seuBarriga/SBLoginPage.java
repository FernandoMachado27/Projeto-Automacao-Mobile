package br.com.fernando.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;

public class SBLoginPage extends BasePage{
	
	public void setEmail(String email) {
		DriverFactor.getDriver().findElement(By.className("android.widget.EditText")).sendKeys(email);
	}
	
	public void setSenha(String senha) {
		DriverFactor.getDriver().findElement(By.xpath("//android.widget.EditText[2]")).sendKeys(senha); // segundo editText
	}
	
	public void entrar() {
		clicarPorTexto("ENTRAR");
	}

}
